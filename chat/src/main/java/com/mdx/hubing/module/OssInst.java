package com.mdx.hubing.module;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.Protocol;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.mdx.hubing.config.AppConfig;

import java.io.File;
import java.io.InputStream;

/**
 * Author: Meng
 * Date: 2023-03-08
 * Desc:
 */
public class OssInst {
    private static boolean hasBucket = false;
    private static final String bucketName = AppConfig.OSS_BUCKET;

    public static OSS initOSS() {
        // OSSClient的配置类，可配置代理、连接超时、最大连接数等参数
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
        // 设置OSSClient允许打开的最大HTTP连接数，默认为1024个。
        conf.setMaxConnections(200);
        // 设置Socket层传输数据的超时时间，默认为50000毫秒。
        conf.setSocketTimeout(10000);
        // 设置建立连接的超时时间，默认为50000毫秒。
        conf.setConnectionTimeout(10000);
        // 设置从连接池中获取连接的超时时间（单位：毫秒），默认不超时。
        conf.setConnectionRequestTimeout(1000);
        // 设置连接空闲超时时间。超时则关闭连接，默认为60000毫秒。
        conf.setIdleConnectionTime(10000);
        // 设置失败请求重试次数，默认为3次。
        conf.setMaxErrorRetry(3);
        // 设置是否支持将自定义域名作为Endpoint，默认支持。
        conf.setSupportCname(true);
        // 设置是否开启二级域名的访问方式，默认不开启。
//        conf.setSLDEnabled(true);
        // 设置连接OSS所使用的协议（HTTP或HTTPS），默认为HTTP。
        conf.setProtocol(Protocol.HTTPS);

        return new OSSClientBuilder().build(AppConfig.OSS_REGION, AppConfig.OSS_ACCESS, AppConfig.OSS_SECRET, conf);
        // 关闭OSSClient。 ossClient.shutdown();
    }

    // 创建存储空间 Bucket
    public static void createBucket(OSS oss) {
        createBucket(oss, bucketName);
    }

    // 创建存储空间 Bucket
    public static void createBucket(OSS oss, String bucketName) {
        if (!hasBucket) {
            hasBucket = queryBucket(oss, bucketName);
            if (!hasBucket) {
                try {
                    oss.createBucket(bucketName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 查询 Bucket
    public static boolean queryBucket(OSS oss, String bucketName) {
        boolean exists = false;
        try {
            // 判断存储空间是否存在。如果返回值为true-存在，false-不存在。
            exists = oss.doesBucketExist(bucketName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    // 删除 Bucket
    public static void deleteBucket(OSS oss, File file) {

    }

    // 保存文件
    public static String saveFile(OSS oss, InputStream file, String path) {
        return saveFile(oss, file, path, bucketName);
    }

    // 保存文件 path 文件完整路径，不能包含Bucket名称;
    public static String saveFile(OSS oss, InputStream file, String path, String bucketName) {
        String fileUrl = null;
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest objRequest = new PutObjectRequest(bucketName, path, file);
            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // objRequest.setMetadata(metadata);

            // 设置该属性可以返回response。如果不设置，则返回的response为空。
            objRequest.setProcess("true");
            PutObjectResult result = oss.putObject(objRequest);
            boolean succeed = result.getResponse().getStatusCode() == 200;
            fileUrl = succeed ? result.getResponse().getUri() : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    // 查询文件
    public static void queryFiles(OSS oss, File file) {

    }

    // 删除文件
    public static int copyFile(OSS oss, String tagPath, String newPath) {
        int code = 0;
        try {
            System.out.println(newPath);
            System.out.println(tagPath);
            oss.copyObject(bucketName, tagPath, bucketName, newPath);
        }catch (Exception e) {
            e.printStackTrace();
            code = -1;
        }
        return code;
    }

    // 删除文件
    public static int deleteFile(OSS oss, String path) {
        int code = 0;
        try {
            oss.deleteObject(bucketName, path);
        }catch (Exception e) {
            e.printStackTrace();
            code = -1;
        }
        return code;
    }

}
