package com.mdx.hubing.model.dto;

import java.io.Serializable;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc: 店铺列表
 */
public class ShopListDto implements Serializable {
    public int id; // 应用id
    public String code; // 应用标识
    public String icon; // 图标
    public String name; // 应用名
    public String version; // 'xx.xx.xx'
    public String intro; //
    public String url; // 安装包下载地址
    public String tag; //
    public String env; // 环境
    public String createTime;
    public String modifyTime;

    @Override
    public String toString() {
        return "StoreListDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
                ", tag='" + tag + '\'' +
                ", env='" + env + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}
