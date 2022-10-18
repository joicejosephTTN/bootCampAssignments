package com.ttn.demo;

/*
Loose coupling is achieved by means of a design that promotes single-responsibility and separation of concerns.

A loosely-coupled class can be consumed and tested independently of other (concrete) classes.

Interfaces are a powerful tool to use for decoupling. Classes can communicate through interfaces rather than other
concrete classes, and any class can be on the other end of that communication simply by implementing the interface.
 */

interface Vehicle {
    public void move();
}

class Cars implements Vehicle{
    @Override
    public void move(){
        System.out.println("Car is moving");
    }
}

class Bikes implements Vehicle{
    @Override
    public void move(){
        System.out.println("Bike is moving");
    }
}

class Traveller {

    // holds the reference to the Vehicle interface
    private Vehicle v;

    public Vehicle getV() {
        return v;
    }
    public void setV(Vehicle v) {
        this.v = v;
    }

    public void startJourney() {
        v.move();
    }
}

public class LooseCoupling {
    public static void main(String[] args) {
        Traveller traveler = new Traveller();
        traveler.setV(new Cars()); // Inject Car dependency
        traveler.startJourney(); // start journey by Car
        traveler.setV(new Bikes()); // Inject Bike dependency
        traveler.startJourney(); // Start journey by Bike
    }
}
