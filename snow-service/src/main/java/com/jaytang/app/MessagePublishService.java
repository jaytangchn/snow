package com.jaytang.app;

public interface MessagePublishService {
    boolean sendMessage(String[] channels,String message);
}
