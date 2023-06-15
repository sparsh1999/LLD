package org.example.messaging.queue.interfaces;

import org.example.messaging.queue.models.Message;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
