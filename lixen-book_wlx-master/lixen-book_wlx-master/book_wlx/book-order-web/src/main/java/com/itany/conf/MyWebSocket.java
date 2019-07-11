package com.itany.conf;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/aa/{userId}")
@Component
public class MyWebSocket {

    private Session session;

    private String userId;

    public static CopyOnWriteArraySet<MyWebSocket> webSockets
            = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId){
        System.out.println("----------"+userId+"------------");
        this.session=session;
        this.userId=userId;
        webSockets.add(this);
    }

    @OnClose
    public void onClose(Session session){
        webSockets.remove(this);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
