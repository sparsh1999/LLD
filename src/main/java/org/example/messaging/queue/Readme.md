sdfh

Topic 
list of messages 

Message
id
content 

enqueue()

TopicSubscriber 
Topic topic 
AtomicInteger offset 
consume, topic.get(offset)

messageAvaiable() {
    Syncronized(offset) {
        while(offset<topic.size( )){
            consume(offset);
            ofseet.increment
        }
    }
}

Producer
produce , topic.enqueue