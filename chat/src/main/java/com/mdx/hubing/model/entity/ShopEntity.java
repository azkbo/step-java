package com.mdx.hubing.model.entity;

import java.io.Serializable;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc: 店铺实体
 */
public class ShopEntity implements Serializable {
    public int id;
    public int uid; // 管理员id
    public int sno; // 标识
    public int status; //
    public double lat; //
    public double lng; //
    public String logo; // 店铺logo
    public String title; // 店铺名称
    public String phone; //
    public String intro; //
    public String address; //
    public String openTime; //
    public String closeTime; //
    public String imgs; //
    public String createDate;

}
