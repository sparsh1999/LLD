package org.example.messaging.queue.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.messaging.queue.interfaces.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class TopicSubscriber{
    ISubscriber subscriber;
    AtomicInteger offset;
}
