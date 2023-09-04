package com.meng.store.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class PublishBody {
    public Integer aid= 0;
    public String name; // 应用名
    public String code; // 应用标识
    public String intro; //
    public String env; // 环境
    public String filePath; // 阿里云存储路径-可用于删除
    public String url; // 安装包下载地址
    public String version; // 'xx.xx.xx'
    public String createTime;
    public String modifyTime;

    @Override
    public String toString() {
        return "AppBody{" +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", intro='" + intro + '\'' +
                ", env='" + env + '\'' +
                ", filePath='" + filePath + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
