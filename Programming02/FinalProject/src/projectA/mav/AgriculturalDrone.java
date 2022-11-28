package projectA.mav;

import projectA.uav.UAV;

import java.util.Objects;

public class AgriculturalDrone extends UAV {
    String brand;
    int capacity ; //for carry

    public AgriculturalDrone() {
        super();
        this.brand = "AgriDrone";
        this.capacity = 100;

    }

    public AgriculturalDrone(double weight, double price, String brand, int capacity) {
        super(weight, price);
        this.brand = brand;
        this.capacity = capacity;
    }

    public AgriculturalDrone(AgriculturalDrone agriculturalDrone){
        super(agriculturalDrone);
        this.brand = agriculturalDrone.brand;
        this.capacity = agriculturalDrone.capacity;
    }


    @Override
    public String toString() {
        return "[Agricultural]\nThis Agricultural Drone is manufactured by " + brand + ". It weight "
                + weight + " pounds, and cost " + price + "$. It can carry up to " + capacity + "Kg.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgriculturalDrone that = (AgriculturalDrone) o;
        return capacity == that.capacity && Objects.equals(brand, that.brand);
    }

}
