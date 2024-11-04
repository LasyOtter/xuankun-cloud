package com.xuankun.generator.service;

import com.xuankun.generator.vo.PreviewVO;

import java.util.List;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成
 *
 * @author jimy
 * 
 */
public interface GeneratorService {

    void downloadCode(Long tableId, ZipOutputStream zip);

    void generatorCode(Long tableId);

    List<PreviewVO> preview(Long tableId);
}
