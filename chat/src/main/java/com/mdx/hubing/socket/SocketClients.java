package com.mdx.hubing.socket;

import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.mdx.hubing.config.AppConfig;
import com.mdx.hubing.socket.entity.WSClient;
import com.mdx.hubing.socket.entity.WSMember;
import com.mdx.hubing.socket.entity.WSRoom;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Author: Meng
 * Date: 2023-03-06
 * Desc:
 */
public class SocketClients {
    private final ConcurrentHashMap<Integer, WSClient> sessionMap;
    private final ConcurrentHashMap<Integer, WSRoom> roomMap;

    private SocketClients() {
        System.out.println("SClients ---> init");
        // TextMessage msg = new TextMessage(" 消息 " + payload);
        // session.sendMessage(msg);
        sessionMap = new ConcurrentHashMap<Integer, WSClient>();
        roomMap = new ConcurrentHashMap<Integer, WSRoom>();
    }

    public static SocketClients instance() {
        return SessionBuild.map;
    }

    // 单例-静态内部类
    private static class SessionBuild {
        public static final SocketClients map = new SocketClients();
    }

    // 添加
    public void add(WSMember member, WebSocketSession session) {
        if (sessionMap.containsKey(member.id)) {
            return;
        }
        if (roomMap.containsKey(member.room)) {
            roomMap.get(member.room).addMember(member);
            System.out.println("SClients ---> room size：" + roomMap.get(member.room).members.size());
        } else {
            roomMap.put(member.room, new WSRoom(member));
        }
        sessionMap.put(member.id, new WSClient(member.id, member.role, member.room, session));
    }

    // 获取
    public WSClient get(int key) {
        if (sessionMap.containsKey(key)) {
            return sessionMap.get(key);
        }
        return null;
    }

    public WSRoom getRoom(int roomId) {
        if (roomMap.containsKey(roomId)) {
            return roomMap.get(roomId);
        }
        return null;
    }

    // 获取
    public WebSocketSession getSession(int key) {
        if (sessionMap.containsKey(key)) {
            WSClient client = sessionMap.get(key);
            return client.getSession();
        }
        return null;
    }

    // 更新
    public void update(int key) {
        try {
            WSClient client = get(key);
            if (client != null) {
//                boolean open = client.getSession().isOpen();
                client.lest = new Date().getTime();
                System.out.println("SClients ---> update：" + key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ping() {
        Set<Integer> keys = sessionMap.keySet();
//    Gson gson = new Gson();
//    String text = gson.toJson(new WSPing(0));
        try {
            for (Integer key : keys) {
                WSClient client = sessionMap.get(key);
                WebSocketSession session = client.getSession();
                if (session.isOpen()) {
                    long time = new Date().getTime() - client.lest;
                    if (time > 3 * AppConfig.PING_Interval) {
                        close(key);
                    } else {
//                        String msg = String.format("{\"tag\":0,\"pid\":%s}", key);
//                        session.sendMessage(new TextMessage(msg));
                    }
                } else {
                    remove(key);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 移除
    public void remove(int key) {
        try {
            if (!sessionMap.containsKey(key)) {
                return;
            }
            sessionMap.remove(key);
            System.out.println("SClients ---> remove：" + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭
    public void close(int key) {
        if (!sessionMap.containsKey(key)) {
            return;
        }
        WSClient client = sessionMap.get(key);
        WebSocketSession session = client.getSession();
        sessionMap.remove(key);
        try {
            session.close();
            System.out.println("SClients ---> close：" + key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
