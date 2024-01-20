package com.mdx.hubing.socket;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import com.google.gson.Gson;

import com.mdx.hubing.config.AppConfig;
import com.mdx.hubing.socket.entity.*;
import com.mdx.hubing.utils.ThreadPool;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Author: Meng
 * Date: 2023-03-06
 * Desc:
 * <p>
 * const socket = new WebSocket('ws://192.168.253.110:9736/xxx?xxx=' + Date.now());
 * socket.onopen = () => {
 * console.log('------>open')
 * }
 * socket.onmessage = (e) => {
 * const msg = JSON.parse(e.data);
 * console.log(msg)
 * }
 * socket.onerror = (e) => {
 * console.log(e)
 * }
 * socket.onclose = () => {
 * console.log('------>close')
 * }
 * const msg = {
 * toUser: 1231231231231,
 * message: '啥哈哈哈哈'
 * }
 * socket.send(JSON.stringify(msg))
 */

@Component
public class SocketHandler extends TextWebSocketHandler {
    public SocketHandler() {
        createPing();
    }

    // 建立连接成功 -连接成功后的操作
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
//         Object token = session.getAttributes().get("token"); session.getId();
//         session.getRemoteAddress()/.getHostName()/.getUri();
        WSMember member = parseQuery(Objects.requireNonNull(session.getUri()));
        SocketClients.instance().add(member, session);
    }

    // 收到消息后的处理
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage message) throws Exception {
//        super.handleMessage(session, message);
//    }

    // 接收消息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        parseMessage(session, payload);
    }

    // 断开连接
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        WSMember member = parseQuery(Objects.requireNonNull(session.getUri()));
        // 用户退出，移除缓存
        System.out.println("SHandler ---> afterConnectionClosed：" + member);
        SocketClients.instance().remove(member.id);
        ArrayList<WSMember> list = SocketClients.instance().getRoom(member.room).members;
        for (int i = list.size()-1; i > -1; i--) {
            if(member.id == list.get(i).id) {
                list.remove(i);
            }
        }
    }

    // 发生错误后的处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

//    @Override
//    public boolean supportsPartialMessages() {
//        return super.supportsPartialMessages();
//    }

    // 解析传人的参数
    private WSMember parseQuery(URI url) {
//        WSQuery query = new WSQuery();
        JSONObject json = new JSONObject();
        String[] params = url.getQuery().split("&");
        try {
            for (String param : params) {
                String[] values = param.split("=");
                json.put(values[0], values[1]);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return new Gson().fromJson(json.toString(), WSMember.class);
    }

    // 处理接收到的消息
    private void parseMessage(WebSocketSession session, String data) {
        System.out.println("SHandler ---> msg:" + data);
        if (data.contains("pid")) {
            try {
                WSPing ping = new Gson().fromJson(data, WSPing.class);
                updatePing(ping.pid);
                sendMessage(session, data);
            } catch (Exception e) {
                e.printStackTrace();
                sendMessage(session, "不支持此类型数据格式");
            }
        } else if (session != null) {
            try {
                Gson gson = new Gson();
                WSMessage wsm = gson.fromJson(data, WSMessage.class);
                wsm.time = new Date().getTime();
                wsm.status = 1;
                WSClient client = SocketClients.instance().get(wsm.fromId);
                WSRoom room = SocketClients.instance().getRoom(client.room);
                ArrayList<WSMember> members = room.members;

                String newMsg = gson.toJson(wsm);
//                System.out.println("SHandler ---> " + client + room.toString());
//                boolean staff = client.role > 0;
                for (WSMember member : members) {
                    boolean need = member.role > 0 || member.num == wsm.num;
                    if (need) {
                        sendMessageById(member.id, newMsg);
                    }
                }
            } catch (Exception e) {
                System.out.println("SHandler ---> parseMsg Err ！" + e.getMessage());
            }
        }
    }

    // 发送消息
    private void sendMessageById(int id, String data) {
        WSClient client = SocketClients.instance().get(id);
//        System.out.println("SHandler ---> sendById " + client);
        if (client != null) {
            sendMessage(client.getSession(), data);
        }
    }

    // 发送消息
    private void sendMessage(WebSocketSession session, String data) {
        try {
            TextMessage msg = new TextMessage(data);
//            System.out.println("SHandler ---> sendMsg ！" + data);
            session.sendMessage(msg);
        } catch (IOException e) {
            System.out.println("SocketHandler ---> sendMsg Err ！" + e.getMessage());
        }
    }

    // 启动心跳扫描-设备连接状态 -5分钟一次
    private void createPing() {
//        System.out.println("SHandler ---> createPing：" + Thread.currentThread().getId());
        ThreadPool.create().getSocketPool().execute(() -> {
            while (true) {
                try {
                    runPing();
                    Thread.sleep(AppConfig.PING_Interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 客户端连续3次，无响应即认为连接断开
     */
    private void runPing() {
//        System.out.println("SHandler ---> runPing：" + Thread.currentThread().getId());
        SocketClients.instance().ping();
    }

    // 更新时间 -
    private void updatePing(int id) {
        SocketClients.instance().update(id);
    }
}
