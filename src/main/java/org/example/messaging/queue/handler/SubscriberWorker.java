package org.example.messaging.queue.handler;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.messaging.queue.models.Message;
import org.example.messaging.queue.models.Topic;
import org.example.messaging.queue.models.TopicSubscriber;

@AllArgsConstructor
public class SubscriberWorker implements Runnable{
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    @SneakyThrows
    @Override
    public void run(){
        synchronized (topicSubscriber) {
            while(topicSubscriber.getOffset().get() >= topic.getMessages().size()) {
                topicSubscriber.wait();
            }
            // pass a message
            int offset = topicSubscriber.getOffset().get();
            Message message = topic.getMessages().get(offset);
            topicSubscriber.getSubscriber().consume(message);
            topicSubscriber.getOffset().compareAndSet(offset, offset+1);
        }
    }

    public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
