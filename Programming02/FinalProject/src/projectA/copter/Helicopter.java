package projectA.copter;

import projectA.airplane.Airplane;

import java.util.Objects;


public class Helicopter extends Airplane {
    int cylinders; // number of cylinder
    int year; // created year
    int capa; // capacity for passenger;

    public Helicopter() {
        super();
        this.cylinders = 5;
        this.year = 2013;
        this.capa = 6;
    }

    public Helicopter(String brand, double price, int horsepower, int cylinders, int year, int capa) {
        super(brand, price, horsepower);
        this.cylinders = cylinders;
        this.year = year;
        this.capa = capa;
    }

    public Helicopter(Helicopter heli) {
        super(heli);
        this.cylinders = heli.cylinders;
        this.year = heli.year;
        this.capa = heli.capa;
    }

    @Override
    public String toString() {
        return "[Helicopter]\nThis Helicopter is manufactured by " + brand + ". The horse power is  "
                + horsepower + ".\nThe price of this helicopter is " + price + "$. This helicopter has " + cylinders +
                " cylinders and It was made in " + year + ". It can carry to " + capa + " passengers. ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Helicopter that = (Helicopter) o;
        return cylinders == that.cylinders && year == that.year && capa == that.capa;
    }

}

