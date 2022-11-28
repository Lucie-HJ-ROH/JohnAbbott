package projectA.copter;

import java.util.Objects;

public class Quadcopter extends Helicopter {
    int maxSpeed; // max flying speed which indicates its maximum moving sppeed.

    public Quadcopter() {
        super();
        this.maxSpeed = 1500;
    }

    public Quadcopter(String brand, double price, int horsepower, int cylinders, int year, int capa, int maxSpeed) {
        super(brand, price, horsepower, cylinders, year, capa);
        this.maxSpeed = maxSpeed;
    }

    public Quadcopter(Quadcopter quadcopter) {
        super(quadcopter);
        this.maxSpeed = quadcopter.maxSpeed;
    }

    @Override
    public String toString() {

        return "[Quadcopter]\nThis Quadcopter is manufactured by " + brand + ". The horse power is  "
                + horsepower + ".\nThe price of this quadcopter is " + price + "$. This quadcopter has " + cylinders +
                " cylinders and It was made in " + year + ". It can carry to " + capa + " passengers. Quadcopter's max speed is " + maxSpeed + ".";


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Quadcopter that = (Quadcopter) o;
        return maxSpeed == that.maxSpeed;
    }

}