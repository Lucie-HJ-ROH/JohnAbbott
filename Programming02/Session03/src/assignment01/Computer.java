package assignment01;

import java.util.Objects;

/**
 * Assignment01
 * Hyunju Roh
 * Written by : Hyunju Roh 2227572
 */

public class Computer {
    private String brand;
    private String model;
    private long serialNumber;
    private double price;
    private static long serialNumberCount = 1000;
    private static int countComputer = 0;


    public Computer(){
        this.brand = "Apple";
        this.model = "MacBook Pro";
        this.price = 5000;
        this.serialNumber = serialNumberCount++;
        countComputer++;
    }

    public Computer(String brand, String model, long price){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.serialNumber = serialNumberCount++;
        countComputer++;
    }
    public Computer(Computer c){
        this.brand = c.brand;
        this.model = c.model;
        this.price = c.price;
        this.serialNumber = serialNumberCount++;
        countComputer++;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "brand : " + brand + '\'' +
                "\t, model='" + model + '\'' +
                "\t, price=" + price +
                "\t, serialNumber=" + serialNumber;
    }

    /**
     * return the number of created objects.
     * default number of countComputer is 0, if object doesn't create it return 0;
     * @return
     */
    public static int findNumberOfCreatedComputers(){
         return countComputer;
    }


    @Override
    /**Two Computer objects are considered equal
     * if they have the same brand, model and price.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Computer)) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.getPrice(), getPrice()) == 0 && Objects.equals(getBrand(), computer.getBrand());
    }


}
