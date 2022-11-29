package projectA.multirotor;

import projectA.copter.Helicopter;

import java.util.Objects;

public class Multirotor extends Helicopter {

    int rotors; // number of rotors which indicates its number of blades

    public Multirotor() {
        super();
        this.rotors = 4;
    }

    public Multirotor(String brand, double price, int horsepower, int cylinders, int year, int capa, int rotors) {
        super(brand, price, horsepower, cylinders, year, capa);
        this.rotors = rotors;
    }

    public Multirotor(Multirotor multirotor) {
        super(multirotor);
        this.rotors = multirotor.rotors;
    }

    @Override
    public String toString() {
        return "[Multirotor]\nThis Multirotor Drone is manufactured by " + brand + ". The horse power is  "
                + horsepower + " and cost is " + price + "$. Multirotor has " + rotors + " rotors ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Multirotor that = (Multirotor) o;
        return rotors == that.rotors;
    }


}
