package com.mdx.hubing.model.dto;

/**
 * Author: Meng
 * Date: 2023-11-11
 * Desc:
 */
public class WxResult {
    public String openid;
    public String unionid;
    public String errmsg;
    public int errcode;

    @Override
    public String toString() {
        return "WxResult{" +
                "openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", errcode=" + errcode +
                '}';
    }
}
