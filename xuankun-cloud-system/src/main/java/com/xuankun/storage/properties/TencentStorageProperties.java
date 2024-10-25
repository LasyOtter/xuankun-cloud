package com.xuankun.storage.properties;

import lombok.Data;

/**
 * 腾讯云存储配置项
 *
 * @author Jimy
 */
@Data
public class TencentStorageProperties {
    private String appId;
    private String region;
    private String endPoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
