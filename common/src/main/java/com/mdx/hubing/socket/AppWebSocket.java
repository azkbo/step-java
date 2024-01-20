package com.mdx.hubing.socket;

//import jakarta.websocket.*;
//import jakarta.websocket.server.PathParam;
//import jakarta.websocket.server.ServerEndpoint;
//import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Author: Meng
 * Date: 2023-10-12
 * Desc:
 */
//@Component
//@ServerEndpoint("/socket/{userId}") // 路径 ws://localhost:8087/socket/userId;
public class AppWebSocket {
//    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
//    private Session session;
//    private String userId;
//
//    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//    //虽然@Component默认是单例模式的，但springboot 还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
//    //  注：底下WebSocket是当前类名
//    private static CopyOnWriteArraySet<AppWebSocket> socketClients = new CopyOnWriteArraySet<>();
//    // 用来存在线连接用户信息
//    private static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<String, Session>();
//
//    /**
//     * 链接成功调用的方法
//     */
//    @OnOpen
//    public void onOpen(Session session, @PathParam(value = "userId") String userId) {
//        try {
//            this.session = session;
//            this.userId = userId;
//            socketClients.add(this);
//            sessionPool.put(userId, session);
//            // "【websocket消息】有新的连接，总数为:"+socketClients.size()
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 链接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//        try {
//            socketClients.remove(this);
//            sessionPool.remove(this.userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     * @param message
//     */
//    @OnMessage
//    public void onMessage(String message) {
//    }
//
//    /**
//     * 发送错误时的处理
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) {
//        error.printStackTrace();
//    }
//
//    // 此为广播消息
//    public void sendAllMessage(String message) {
//        for (AppWebSocket webSocket : socketClients) {
//            try {
//                if (webSocket.session.isOpen()) {
//                    webSocket.session.getAsyncRemote().sendText(message);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // 此为单点消息
//    public void sendOneMessage(String userId, String message) {
//        Session session = sessionPool.get(userId);
//        if (session != null && session.isOpen()) {
//            try {
//                session.getAsyncRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // 此为单点消息(多人)
//    public void sendMoreMessage(String[] userIds, String message) {
//        for (String userId : userIds) {
//            Session session = sessionPool.get(userId);
//            if (session != null && session.isOpen()) {
//                try {
//                    session.getAsyncRemote().sendText(message);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
}
