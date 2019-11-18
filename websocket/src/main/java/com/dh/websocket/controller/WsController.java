package com.dh.websocket.controller;



import com.dh.websocket.message.WiselyMessage;
import com.dh.websocket.message.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WsController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    @ResponseBody
    public String say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("欢迎你，"+message.getName()+"!").toString();
        }

}
