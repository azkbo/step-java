package com.mdx.hubing.config;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class AppConfig {
    // 阿里云存储
    public final static String OSS_REGION = "oss-cn-hangzhou";
    public final static String OSS_ACCESS = "";
    public final static String OSS_SECRET = "";
    public final static String OSS_BUCKET = "appstore"; // oss仓库根目录名称

    // 微信 配置
    public final static String WX_APPID = "wx601c97e2ab367f70";
    public final static String WX_SECRET = "0c3a2720ab2a1275d194763fd89ad56b";

    // WebSocket 配置
    public final static String WS_PATH = "link";
    public final static int PING_Interval = 1000 * 60; // 心跳间隔
}
