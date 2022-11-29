package projectA.mav;

import projectA.uav.UAV;

import java.util.Objects;

public class MAV extends UAV {
    String model;
    double size;

    public MAV() {
        super();
        this.model = "UAV";
        this.size = 1200;
    }

    public MAV(double weight, double price, String model, double size) {
        super(weight, price);
        this.model = model;
        this.size = size;
    }

    public MAV(MAV mav) {
        super(mav);
        this.model = mav.model;
        this.size = mav.size;
    }

    @Override
    public String toString() {
        return "[MAV]\nThis MAV's model name is " + model + ". It weight "
                + weight + " pounds, and cost " + price + "$. Size of this MAV is  " + size + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MAV mav = (MAV) o;
        return Double.compare(mav.size, size) == 0 && Objects.equals(model, mav.model);
    }

}
