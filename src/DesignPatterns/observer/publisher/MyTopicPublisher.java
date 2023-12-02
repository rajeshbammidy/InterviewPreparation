package DesignPatterns.observer.publisher;

import DesignPatterns.observer.subscriber.Subscriber;

import java.util.*;

public class MyTopicPublisher implements TopicPublisher {
    List<Subscriber> subscriberList;
    private String message;
    private boolean isChanged;
    private final Object MUTEX = new Object();

    public MyTopicPublisher() {
        subscriberList = new ArrayList<>();
    }

    @Override

    public void register(Subscriber subscriber) {
        subscriberList.add(subscriber);

        if (subscriber == null) throw new NullPointerException("Null Observer");
        synchronized (this) {
            if (!subscriberList.contains(subscriber)) subscriberList.add(subscriber);
        }

    }

    @Override
    public void unRegister(Subscriber subscriber) {
        synchronized (MUTEX) {
            subscriberList.remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (this) {
            if (!isChanged)
                return;
            for (Subscriber obj : subscriberList) {
                obj.update();
            }
            this.isChanged = false;
        }

    }

    @Override
    public Object getUpdate() {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message Posted to Topic:" + msg);
        this.message = msg;
        this.isChanged = true;
        notifySubscribers();
    }


}
