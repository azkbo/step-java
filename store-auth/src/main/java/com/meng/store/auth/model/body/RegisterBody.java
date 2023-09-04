package com.meng.store.auth.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class RegisterBody {
    public int id;
    public String password;
    public String nickname;
    public String account;
    public String email;
    public String icon;
    public String role = "9";
    public String token;
    public String createDate;

    @Override
    public String toString() {
        return "RegisterBody{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", roles='" + role + '\'' +
                ", token='" + token + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
