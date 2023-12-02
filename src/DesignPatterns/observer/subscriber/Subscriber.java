package DesignPatterns.observer.subscriber;

import DesignPatterns.observer.publisher.TopicPublisher;

public interface Subscriber {
    void update();

    void setPublisher(TopicPublisher topicPublisher);
}
