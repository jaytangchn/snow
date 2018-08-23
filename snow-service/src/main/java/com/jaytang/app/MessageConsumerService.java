package com.jaytang.app;

public interface MessageConsumerService {
    void handleMessage(String[] channels);
    String getMsg();
}
