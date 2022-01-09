package DesignPatterns;

/**
 * Project: InterviewPreparation
 * Package: DesignPatterns
 * Date: Jan, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 **/


/**
 * Singleton DesignPattern:
 * <p>
 * Creational design pattern
 * Only one instance of the class is allowed
 * Other classes should be able to get the instance of singleton class via a static method
 * Use in Logging,Cache,Session,Drivers
 * <p>
 * <p>
 * Implementation:
 * Constructor should be made private
 * Public and static method to return the instance
 * private static instance
 * <p>
 * Types of Initialisation:
 * Eager Initialisation
 * Lazy Initialisation
 * Thread safe method Initialisation
 * Thread safe block Initialisation
 */


class EagerSingletonDP {
    private EagerSingletonDP() {
    }

    private static EagerSingletonDP instance = new EagerSingletonDP();

    public static EagerSingletonDP getInstance() {
        return instance;
    }
}

class LazySingletonDP {
    private LazySingletonDP() {
    }

    private static LazySingletonDP instance = null;

    public static LazySingletonDP getInstance() {
        //initializes only when there is a need
        if (instance == null) {
            instance = new LazySingletonDP();
        }
        return instance;
    }
}

class ThreadSafeSingletonDP {
    private ThreadSafeSingletonDP() {

    }

    private static ThreadSafeSingletonDP instance = null;

    //instead of making the entire method as synchronized we can use synchronized block as well
    public static synchronized ThreadSafeSingletonDP getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingletonDP();
        }
        return instance;
    }
}

class SingletonSynchronizedDP {
    private SingletonSynchronizedDP() {

    }

    private static SingletonSynchronizedDP instance = null;

    //synchronized block
    public static SingletonSynchronizedDP getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronizedDP.class) {
                instance = new SingletonSynchronizedDP();
            }

        }
        return instance;
    }
}

public class SingletonDP {
    public static void main(String[] args) {
        LazySingletonDP instance1 = LazySingletonDP.getInstance();
        LazySingletonDP instance2 = LazySingletonDP.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
