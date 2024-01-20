package com.mdx.hubing.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class RegisterBody {
    public String pwd;
    public String nickname;
    public String email = null;
    public String phone = null;
    public String sign = null;
    public String icon = null;

    @Override
    public String toString() {
        return "RegisterBody{" +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sign='" + sign + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
