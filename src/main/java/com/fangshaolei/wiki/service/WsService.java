package com.fangshaolei.wiki.service;

import com.fangshaolei.wiki.websocket.WebSocketServer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fongshaolei
 * @version 1.0.0
 * @ClassName WsService
 * @Description
 * @createTime 2022/06/24 15:12
 **/
@Service
public class WsService {
    @Resource
    public WebSocketServer webSocketServer;

    @Async
    public void sendInfo(String message) {
        webSocketServer.sendInfo(message);
    }
}
