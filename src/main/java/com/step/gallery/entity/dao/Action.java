package com.step.gallery.entity.dao;

/**
 * Create By: Meng
 * Create Date: 2022-10-19
 */
public class Action {
    public String tId; // 坦克ID
    public String direction; // 移动或攻击方向,有UP、RIGHT、DOWN、LEFT、WAIT
    public String type; // 移动或攻击(MOVE、FIRE)
    public int length; // 移动或攻击距离
    public boolean useGlod = false; // 是否使用复活币
    public String lng = ""; // 坐标
    public boolean sign = false; // 是否已被队友标记

    public Action(String tId, String typ, int len, String orient) {
        this.tId = tId;
        this.type = typ;
        this.length = len;
        this.direction = orient;
    }

    @Override
    public String toString() {
        return "Action{" +
                "tId='" + tId + '\'' +
                ", direction='" + direction + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", useGlod=" + useGlod +
                ", lng='" + lng + '\'' +
                ", sign=" + sign +
                '}';
    }
}
