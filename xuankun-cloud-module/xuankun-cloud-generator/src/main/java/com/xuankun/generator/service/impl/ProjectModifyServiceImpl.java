package com.xuankun.generator.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xuankun.framework.common.page.PageResult;
import com.xuankun.framework.common.query.DbQuery;
import com.xuankun.framework.common.utils.ProjectUtils;
import com.xuankun.framework.mybatis.service.impl.BaseServiceImpl;
import lombok.AllArgsConstructor;
import com.xuankun.generator.dao.ProjectModifyDao;
import com.xuankun.generator.entity.ProjectModifyEntity;
import com.xuankun.generator.service.ProjectModifyService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 项目名变更
 *
 * @author jimy
 * 
 */
@Service
@AllArgsConstructor
public class ProjectModifyServiceImpl extends BaseServiceImpl<ProjectModifyDao, ProjectModifyEntity> implements ProjectModifyService {

    @Override
    public PageResult<ProjectModifyEntity> page(DbQuery query) {
        IPage<ProjectModifyEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    @Override
    public byte[] download(ProjectModifyEntity project) throws IOException {
        // 原项目根路径
        File srcRoot = new File(project.getProjectPath());

        // 临时项目根路径
        File destRoot = new File(ProjectUtils.getTmpDirPath(project.getModifyProjectName()));

        // 排除的文件
        List<String> exclusions = StrUtil.split(project.getExclusions(), ProjectUtils.SPLIT);

        // 获取替换规则
        Map<String, String> replaceMap = getReplaceMap(project);

        // 拷贝项目到新路径，并替换路径和文件名
        ProjectUtils.copyDirectory(srcRoot, destRoot, exclusions, replaceMap);

        // 需要替换的文件后缀
        List<String> suffixList = StrUtil.split(project.getModifySuffix(), ProjectUtils.SPLIT);

        // 替换文件内容数据
        ProjectUtils.contentFormat(destRoot, suffixList, replaceMap);

        // 生成zip文件
        File zipFile = ZipUtil.zip(destRoot);

        byte[] data = FileUtil.readBytes(zipFile);

        // 清空文件
        FileUtil.clean(destRoot.getParentFile().getParentFile());

        return data;
    }

    /**
     * 获取替换规则
     */
    private Map<String, String> getReplaceMap(ProjectModifyEntity project) {
        Map<String, String> map = new LinkedHashMap<>();

        // 项目路径替换
        String srcPath = "src/main/java/" + project.getProjectPackage().replaceAll("\\.", "/");
        String destPath = "src/main/java/" + project.getModifyProjectPackage().replaceAll("\\.", "/");
        map.put(srcPath, destPath);

        // 项目包名替换
        map.put(project.getProjectPackage(), project.getModifyProjectPackage());

        // 项目标识替换
        map.put(project.getProjectCode(), project.getModifyProjectCode());
        map.put(StrUtil.upperFirst(project.getProjectCode()), StrUtil.upperFirst(project.getModifyProjectCode()));

        return map;
    }

    @Override
    public boolean save(ProjectModifyEntity entity) {
        entity.setExclusions(ProjectUtils.EXCLUSIONS);
        entity.setModifySuffix(ProjectUtils.MODIFY_SUFFIX);
        entity.setCreateTime(new Date());
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<ProjectModifyEntity> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<ProjectModifyEntity> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }
}