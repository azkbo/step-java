package com.step.gallery.entity.dao;

/**
 * Create By: Meng
 * Create Date: 2022-10-19
 */
public class Point {
    public int x = 0;
    public int y = 0;
    public int role = 0; // 类型 0队友；1障碍物；2敌方；3boss；4复活币
    public String id = ""; // 坦克id
    public String lng = ""; // 坐标
    public boolean sign = false; // 是否已被队友标记

    public Point(int x, int y, String id, int role) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.role = role;
        this.lng = x + "," + y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", role=" + role +
                ", id='" + id + '\'' +
                ", lng='" + lng + '\'' +
                ", sign=" + sign +
                '}';
    }
}
