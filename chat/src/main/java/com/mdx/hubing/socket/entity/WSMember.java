package com.mdx.hubing.socket.entity;

/**
 * Author: Meng
 * Date: 2023-10-16
 * Desc:
 */
public class WSMember {
    public int id;
    public int room;
    public int role;
    public int num;

    @Override
    public String toString() {
        return "WSMember{" +
                "id=" + id +
                ", room=" + room +
                ", num=" + num +
                ", role=" + role +
                '}';
    }
}
