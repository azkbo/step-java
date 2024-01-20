package com.mdx.hubing.socket.entity;

import com.google.gson.Gson;

/**
 * Author: Meng
 * Date: 2023-03-06
 * Desc:
 */
public class WSMessage {
//  public int mold; // 类型 -1失败；0-消息；1通知；...
  public int tag; // 标识 1-文本；2-图片；3-语音；4-视频；5-表情
  public int status; // 状态 0-发送中；1-已发；2已读；3-编辑；4-撤销；5-删除；6-失败
  public String data; // 消息体
//  public String uid;
//  public int toId;
  public int num;
  public int fromId;
//  public int room;
  public long time;

  public WSMessage() {

  }

  public WSMessage(String data, int room, int fromId) {
    this.data = data;
    this.tag = 1;
    this.status = 0;
//    this.room = room;
    this.fromId = fromId;
  }

  public static String sendRoom(String msg, int toId, int roomId) {
    Gson gson = new Gson();
    return gson.toJson(new WSMessage());
  }

  public static String editMsg() {
    Gson gson = new Gson();
    return gson.toJson(new WSMessage());
  }

  public static String cancelMsg() {
    Gson gson = new Gson();
    return gson.toJson(new WSMessage());
  }

  public static String deleteMsg() {
    Gson gson = new Gson();
    return gson.toJson(new WSMessage());
  }

  public static String readMsg() {
    Gson gson = new Gson();
    return gson.toJson(new WSMessage());
  }

  @Override
  public String toString() {
    return "WSMessage{" +
            ", status=" + status +
            ", data='" + data + '\'' +
            ", num=" + num +
//            ", room=" + room +
            ", fromId=" + fromId +
            '}';
  }
}
