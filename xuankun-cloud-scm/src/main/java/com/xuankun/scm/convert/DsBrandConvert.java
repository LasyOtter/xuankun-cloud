package com.xuankun.scm.convert;

import com.xuankun.scm.entity.DsBrandEntity;
import com.xuankun.scm.vo.DsBrandVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DsBrandConvert {

    DsBrandConvert INSTANCE = Mappers.getMapper(DsBrandConvert.class);

    DsBrandVO convert(DsBrandEntity entity);

    DsBrandEntity convert(DsBrandVO vo);

    List<DsBrandVO> convertList(List<DsBrandEntity> list);
}
