package projectA.airplane;

import java.util.Objects;

public class Airplane {
    public String brand;
    public double price;
    public int horsepower;

    //default constructor initialize .
    public Airplane() {
        this.brand = "Asiana";
        this.price = 1000;
        this.horsepower = 100;
    }

    public Airplane(String brand, double price, int horsepower) {
        this.brand = brand;
        this.price = price;
        this.horsepower = horsepower;
    }

    public Airplane(Airplane airplane){
        this.brand = airplane.brand;
        this.horsepower = airplane.horsepower;
        this.price = airplane.price;
    }

    @Override
    public String toString() {
        return "[Airplane]\nThis Airplane is manufactured by " + brand + ". The horse power is  "
                + horsepower + ".  The price of this airplane is " + price + "$";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Double.compare(airplane.price, price) == 0 && horsepower == airplane.horsepower && Objects.equals(brand, airplane.brand);
    }

}
