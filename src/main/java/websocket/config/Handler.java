package websocket.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler extends TextWebSocketHandler {

    private List<WebSocketSession> list = new ArrayList<>();




    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished"+session);
        list.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for(WebSocketSession s : list){
                s.sendMessage(message);
        }
    }
}
