package activity02;

import java.util.Objects;

public class CellPhone {
    private String brand;
    private double price;
    private long phoneSerial;
    private static long serialNumber = 100000000;

    public CellPhone(){
        this.brand = "LG";
        this.price = 1000;
        this.phoneSerial = serialNumber;
        serialNumber++;
    }

    public CellPhone(String brand, double price){
        this.brand = brand;
        this.price = price;
        this.phoneSerial = serialNumber;
        serialNumber++;
    }

    public CellPhone(CellPhone c){
        this.brand = c.brand;
        this.price = c.price;
        this.phoneSerial = serialNumber;
        serialNumber++;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public long getPhoneSerial() {
        return phoneSerial;
    }

    public void showInfo(){
        System.out.println("The brand of this phone is " + brand + ", price is " + price +"$ , serial number is  "+ phoneSerial) ;
    }

    @Override
    public boolean equals(Object o) {
        CellPhone cellPhone = (CellPhone) o;
        return Double.compare(cellPhone.price, price) == 0 && Objects.equals(brand, cellPhone.brand);
    }

}
