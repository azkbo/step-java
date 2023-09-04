package com.meng.store.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class AppBody {
    public int id;
    public String icon; // 图标
    public String name; // 应用名
    public String code; // 应用标识
    public String intro; //
    public String url; // 安装包下载地址
    public String version; // 'xx.xx.xx'
    public String tag; //
    public String modifyTime;

    @Override
    public String toString() {
        return "AppBody{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", tag='" + tag + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
