package com.example.ServiceExtended;

/**
 * Created by sanea on 06.04.15.
 */
//Events are POJO (plain old Java object) without any specific requirements.
public class MessageEvent {
    public final String message;

    public MessageEvent(String message) {
        this.message = message;
    }
}
