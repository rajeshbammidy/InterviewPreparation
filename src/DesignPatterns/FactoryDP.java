package DesignPatterns;

/**
 * Project: InterviewPreparation
 * Package: DesignPatterns / FactoryDP
 * Date: Jan, 2022
 * Author: rajeshbammidi
 * Happy Coding :)
 * <p>
 * <p>
 * Creation Design Pattern
 * <p>
 * Used when we have multiple sub-classes for a super class & based on the input we want to return the one class instance
 * <p>
 * Abstraction between the implementation & client classes
 * <p>
 * Remove the instantiation of the client class in the client side
 * <p>
 * Implementaion:
 * <p>
 * Factory class has a static method which returns the basic class object
 **/


abstract class Vehicle {

    abstract int getWheel();

    @Override
    public String toString() {
        return getWheel() + " - wheels";
    }
}


class Bike extends Vehicle {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return wheel;
    }
}

class Car extends Vehicle {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return wheel;
    }
}

//superClass_Factory
class VehicleFactory {
    public static Vehicle getInstance(String instanceType, int wheel) {
        switch (instanceType) {
            case "bike":
                return new Bike(wheel);
            case "car":
                return new Car(wheel);
            default:
                return null;
        }
    }
}

public class FactoryDP {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getInstance("car", 4);
        System.out.println(vehicle);
    }
}
