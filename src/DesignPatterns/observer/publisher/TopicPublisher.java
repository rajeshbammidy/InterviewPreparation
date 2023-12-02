package DesignPatterns.observer.publisher;

import DesignPatterns.observer.subscriber.Subscriber;

public interface TopicPublisher {
    void register(Subscriber subscriber);

    void unRegister(Subscriber subscriber);

    void notifySubscribers();

    public Object getUpdate();

}
