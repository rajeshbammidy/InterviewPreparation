package DesignPatterns.observer.subscriber;

import DesignPatterns.observer.publisher.TopicPublisher;

public class Subscriber1 implements Subscriber {
    private String subscriberName;

   public Subscriber1(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    private TopicPublisher topicPublisher;

    @Override
    public void update() {
        String msg = (String) topicPublisher.getUpdate();
        if (msg == null) {
            System.out.println(topicPublisher + ":: No new message");
        } else
            System.out.println(topicPublisher + ":: Consuming message::" + msg);

    }

    @Override
    public void setPublisher(TopicPublisher topicPublisher) {
        this.topicPublisher = topicPublisher;
    }
}
