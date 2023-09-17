package org.example.messaging.queue.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    String id;
    String name;
    @Getter List<Message> messages;

    @Getter List<TopicSubscriber> subscribers;

    public Topic(String id, String name){
        this.id = id;
        this.name = name;
        this.messages = new ArrayList<>();
    }
}
