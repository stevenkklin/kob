package com.kob.backend.consumer;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/websocket/{token}")  // 注意不要以'/'结尾
public class WebSocketServer {
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        // 建立连接
    }

    @OnClose
    public void onClose() {
        // 关闭链接
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        // 从Client接收消息
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}


