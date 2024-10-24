package com.xuankun.storage.properties;

import lombok.Data;

/**
 * 阿里云存储配置项
 *
 * @author Jimy
 */
@Data
public class AliyunStorageProperties {
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
