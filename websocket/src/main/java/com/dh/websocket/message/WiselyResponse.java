package com.dh.websocket.message;

/**
 * 服务端向浏览器发送此类的消息
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
