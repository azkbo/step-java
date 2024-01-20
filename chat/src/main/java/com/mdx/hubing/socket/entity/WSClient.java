package com.mdx.hubing.socket.entity;

import org.springframework.web.socket.WebSocketSession;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2023-10-14
 * Desc:
 */
public class WSClient {
    public WebSocketSession session;
    public int uid;
    public int room;
    public int role = 0; // 角色 0普通顾客，1店员
    public long time;
    public long lest;

    public WSClient(int uid, int role, int room, WebSocketSession session) {
        this.uid = uid;
        this.role = role;
        this.room = room;
        this.session = session;
        time = new Date().getTime();
        lest = time;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "WSClient{" +
                ", uid=" + uid +
                ", room=" + room +
                ", role=" + role +
                ", time=" + time +
                ", lest=" + lest +
                '}';
    }
}
