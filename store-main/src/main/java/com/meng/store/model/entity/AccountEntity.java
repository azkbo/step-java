package com.meng.store.model.entity;

import com.meng.store.utils.DateTools;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class AccountEntity {
    public int id;
    public long uid;
    public String password;
    public String nickname;
    public String phone;
    public String email;
    public String wxId;
    public String icon;
    public String birth = null;
    public int integral = 1;
    public int member = 1;
    public int level = 1;
    public int score = 1;
    public int roleCode = 9; //
    public int shareCode = 0; //
    public int shareId = 0; //
    public String createDate;

    public AccountEntity() {
        createDate = DateTools.currentDate();
    }

    public AccountEntity generate() {
        AccountEntity account = new AccountEntity();
        account.uid = 928893;
        return account;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "uid=" + uid +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", wxId='" + wxId + '\'' +
                ", icon='" + icon + '\'' +
                ", birth='" + birth + '\'' +
                ", integral=" + integral +
                ", member=" + member +
                ", level=" + level +
                ", score=" + score +
                ", roleCode=" + roleCode +
                ", shareCode=" + shareCode +
                ", shareId=" + shareId +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
