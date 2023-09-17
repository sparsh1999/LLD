package org.example.messaging.queue.handler;

import lombok.Getter;
import org.example.messaging.queue.models.Message;
import org.example.messaging.queue.models.Topic;
import org.example.messaging.queue.models.TopicSubscriber;

import java.util.List;
import java.util.Map;

public class TopicHandler {
    // subcriberId, worker
    Map<String, SubscriberWorker> workerMap;
    Topic topic;

    void publishMessage(Message message) {
        topic.getMessages().add(message);
        for (TopicSubscriber subscriber : topic.getSubscribers()){
            notifyWorker(subscriber);
        }
    }

    private void notifyWorker(TopicSubscriber topicSubscriber) {
        final String id = topicSubscriber.getSubscriber().getId();
        if (!workerMap.containsKey(id)) {
            SubscriberWorker worker = new SubscriberWorker(topic, topicSubscriber);
            workerMap.put(id, worker);
            new Thread(worker).start();
        }
        SubscriberWorker worker = workerMap.get(id);
        worker.wakeUpIfNeeded();
    }
}
