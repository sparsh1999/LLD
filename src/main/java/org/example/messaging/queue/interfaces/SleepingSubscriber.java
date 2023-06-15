package org.example.messaging.queue.interfaces;

import lombok.AllArgsConstructor;
import org.example.messaging.queue.models.Message;

@AllArgsConstructor
public class SleepingSubscriber implements ISubscriber{
    String id;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.print("");
    }
}
