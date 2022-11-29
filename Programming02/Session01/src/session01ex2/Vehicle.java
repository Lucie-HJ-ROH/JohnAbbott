package session01ex2;

import java.util.Objects;

public class Vehicle {
    private int numOfDoor;
    private double price;
    private int maxSpeed;

    public int setNumOfDoor(int numOfDoor) {
        this.numOfDoor = numOfDoor;
        return numOfDoor;
    }

    public double setPrice(double price) {
        this.price = price;
        return price;
    }

    public int setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return maxSpeed;
    }

    public int getNumOfDoor() {
        return numOfDoor;
    }

    public double getPrice() {
        return price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        Vehicle vehicle = (Vehicle) o;
        return getNumOfDoor() == vehicle.getNumOfDoor() && Double.compare(vehicle.getPrice(), getPrice()) == 0 && getMaxSpeed() == vehicle.getMaxSpeed();
    }

    public void showInfo(){
        System.out.println("The vehicle has " + numOfDoor + " door. ");
        System.out.println("The price of vehicle is " + price + " $. ");
        System.out.println("The maximum speed of of vehicle is " + maxSpeed + " km. ");
    }

}
