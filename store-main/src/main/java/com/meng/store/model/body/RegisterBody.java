package com.meng.store.model.body;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public class RegisterBody {
    public long uid;
    public String password;
    public String name;
    public String email = null;
    public String phone = null;
    public String wxId = null;
    public String icon = null;

    @Override
    public String toString() {
        return "RegisterBody{" +
                "uid=" + uid +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", wxId='" + wxId + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
