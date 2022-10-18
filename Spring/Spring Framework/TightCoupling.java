package com.ttn.demo;
/*
When two classes are highly dependent on each other, it is called tight coupling. It occurs when a class takes
too many responsibilities or where a change in one class requires changes in the other class. In tight coupling,
an object (parent object) creates another object (child object) for its usage.
*/


class Car  {
    public void move() {
        System.out.println("Car is moving");
    }
}

// the Traveler class is creating Car object to interact with it using the move() method.
class Traveler {
    Car c = new Car();
    public void startJourney() {
        c.move();
    }
//Now if you want to use bike object you will have to make changes in Traveller class
}
public class TightCoupling {

    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        traveler.startJourney();
    }
}
