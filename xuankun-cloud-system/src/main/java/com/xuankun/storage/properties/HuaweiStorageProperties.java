package com.xuankun.storage.properties;

import lombok.Data;

/**
 * 华为云存储配置项
 *
 * @author Jimy
 */
@Data
public class HuaweiStorageProperties {
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
