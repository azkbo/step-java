package com.mdx.hubing.socket.entity;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-10-16
 * Desc:
 */
public class WSRoom {
    public int id;
    public ArrayList<WSMember> members = new ArrayList<>();

    public WSRoom(int roomId) {
        this.id = roomId;
    }

    public WSRoom(WSMember member) {
        this.id = member.room;
        members.add(member);
    }

    public void addMember(WSMember member) {
        members.add(member);
    }

    @Override
    public String toString() {
        return "WSRoom{" +
                "id=" + id +
                ", members=" + members +
                '}';
    }
}
