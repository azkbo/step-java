package com.mdx.hubing.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class LoginBody {
    public int id;
    public String pwd;
    public String nickname;
    public String email;
    public String phone;
    public String sign;
    public String icon;
    public String code;

    @Override
    public String toString() {
        return "LoginBody{" +
                "icon='" + icon + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sign='" + sign + '\'' +
                ", pwd='" + pwd + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
