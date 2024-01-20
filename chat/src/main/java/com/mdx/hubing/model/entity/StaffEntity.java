package com.mdx.hubing.model.entity;

import java.io.Serializable;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc: 实体
 */
public class StaffEntity implements Serializable {
    public int id;
    public int sid;
    public int uid;
    public int level; // 职位
    public int status;
    public String name;
    public String intro;
    public String phone;
}
