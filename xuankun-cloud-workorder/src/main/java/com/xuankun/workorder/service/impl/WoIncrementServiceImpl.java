package com.xuankun.workorder.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuankun.common.service.impl.CrudServiceImpl;
import com.xuankun.workorder.service.WoIncrementService;
import com.xuankun.workorder.dao.WoIncrementDao;
import com.xuankun.workorder.dto.WoIncrementDTO;
import com.xuankun.workorder.entity.WoIncrementEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jimy
 * @Title: WoIncrementServiceImpl
 * @Package com.xuankun.workorder.service.impl
 * @Description: todo
 * @date 2022/9/19:15:45
 */
@Service
public class WoIncrementServiceImpl extends CrudServiceImpl<WoIncrementDao, WoIncrementEntity, WoIncrementDTO> implements WoIncrementService {
    @Override
    public QueryWrapper<WoIncrementEntity> getWrapper(Map<String, Object> params) {
        String id = (String)params.get("id");
        String woDate = (String)params.get("woDate");

        QueryWrapper<WoIncrementEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);
        wrapper.eq(StringUtils.isNotBlank(woDate), "wo_date", woDate);
        return wrapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String getIncrementByWoDate() {
        String incrementStr = "000001";
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowStr = sdf.format(now);
        Map<String, Object> params = new HashMap<>();
        params.put("woDate",nowStr);
        WoIncrementEntity entity = this.baseDao.selectOne(this.getWrapper(params));
        if(entity != null){
            DecimalFormat df = new DecimalFormat("000000");
            incrementStr = df.format(entity.getAutoincrement() + 1);
            entity.setAutoincrement(Long.valueOf(incrementStr));
            this.baseDao.updateById(entity);
        }else{
            entity = new WoIncrementEntity();
            entity.setWoDate(nowStr);
            entity.setAutoincrement(Long.valueOf(incrementStr));
            this.baseDao.insert(entity);
        }
        StringBuilder sb = new StringBuilder("OM");
        sb.append(nowStr).append(incrementStr);
        return sb.toString();
    }
}
