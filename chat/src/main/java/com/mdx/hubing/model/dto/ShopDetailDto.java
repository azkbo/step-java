package com.mdx.hubing.model.dto;

import java.io.Serializable;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc: 店铺详情
 */
public class ShopDetailDto extends ShopListDto implements Serializable {
    public int uid=1; // id
    public String memo; //

    @Override
    public String toString() {
        return "StoreDetailDto{" +
                "memo='" + memo + '\'' +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", intro='" + intro + '\'' +
                ", url='" + url + '\'' +
                ", tag='" + tag + '\'' +
                ", env='" + env + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
