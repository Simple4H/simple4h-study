package com.simple4h.sample.config;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * WebSocketServer
 *
 * @author Simple4H
 */
@Component
@Slf4j
@Service
@ServerEndpoint("/app/websocket/{userId}")
public class WebSocketServer {

    private Session session;

    private static final CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    private Long userId;

    @OnOpen
    public synchronized void onOpen(Session session, @PathParam("userId") Long userId) {
        this.session = session;
        this.userId = userId;
        webSocketSet.add(this);
        log.info("建立新的连接,用户Id:{},总数:{}", userId, webSocketSet.size());
    }

    @OnClose
    public synchronized void onClose(@PathParam("userId") Long userId) {
        webSocketSet.remove(this);
        log.info("连接断开, userId:{}, 总数:{}", userId, webSocketSet.size());
    }

    @OnMessage
    public synchronized void onMessage(String message, @PathParam("userId") Long userId) {
        log.info("接收到userId:{}信息,内容:{}", userId, message);
    }

    public static synchronized void sendMessage(Long userId, String message) {
        if (Objects.isNull(userId)) {
            throw new RuntimeException("用户Id不能为空");
        }

        List<WebSocketServer> webSocketServers = webSocketSet.stream().filter(s -> s.userId.equals(userId)).collect(Collectors.toList());
        webSocketServers.forEach(server -> {
            try {
                server.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.error("发送信息异常,userId:{}, message:{}", userId, message);
                throw new RuntimeException("发送信息异常！");
            }
        });
    }

}
