package com.mdx.hubing.model.entity;

import com.mdx.hubing.utils.DateTools;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class AccountEntity {
    private int id;
    private long uid;
    private String pwd;
    private String sign;
    private String phone;
    private String email;
    private String nickname;
    private String icon;
    private int tag = 1;
    private int level = 9;
    private int score = 1;
    private int grade = 1;
    private int channel = 0; //
    private String shareCode; //
    private String createDate;

    public AccountEntity() {
        createDate = DateTools.currentDate();
        shareCode = Integer.toString((int) (100000 * Math.random()) + 100000);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", sign='" + sign + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", score=" + score +
                ", grade=" + grade +
                ", shareCode=" + shareCode +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
