package dao;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuankun.framework.common.rest.param.PageParam;
import com.xuankun.framework.mybatis.dao.BaseManager;
import com.xuankun.framework.mybatis.utils.MpUtil;
import entity.UpdateFileInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**   
* 
* @author xxm  
* @date 2022/1/12 
*/
@Slf4j
@Repository
@RequiredArgsConstructor
public class UpdateFileManager extends BaseManager<UpdateFileMapper, UpdateFileInfo> {

    /**
     * 分页
     */
    public Page<UpdateFileInfo> page(PageParam pageParam){
        Page<UpdateFileInfo> mpPage = MpUtil.getMpPage(pageParam, UpdateFileInfo.class);
        return lambdaQuery()
                .orderByDesc(UpdateFileInfo::getId)
                .page(mpPage);
    }
}
