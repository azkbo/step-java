package com.meng.store.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class LoginBody {
    public String email;
    public String phone;
    public String wxId;
    public String password;
    public String code;

    @Override
    public String toString() {
        return "LoginBody{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", wxId='" + wxId + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
