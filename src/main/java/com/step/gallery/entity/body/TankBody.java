package com.step.gallery.entity.body;

/**
 * Create By: Meng
 * Create Date: 2022-10-19
 */
public class TankBody {
    public String tId;
    public String name;
    public int gongji;
    public int shengming;
    public int shengyushengming;
    public int yidong;
    public int shecheng;
    public int shiye;
    public boolean mingzhong;
    public String lng = "";
    public boolean sign = false;

    @Override
    public String toString() {
        return "TankBody{" +
                "tId='" + tId + '\'' +
                ", name='" + name + '\'' +
                ", gongji=" + gongji +
                ", shengming=" + shengming +
                ", shengyushengming=" + shengyushengming +
                ", yidong=" + yidong +
                ", shecheng=" + shecheng +
                ", shiye=" + shiye +
                ", mingzhong=" + mingzhong +
                ", lng='" + lng + '\'' +
                ", sign=" + sign +
                '}';
    }
}
