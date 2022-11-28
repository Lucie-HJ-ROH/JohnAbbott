package projectA.uav;

public class UAV {

    public double weight;
    public double price;

    public UAV() {
        this.weight = 50;
        this.price = 1500;
    }
    public UAV(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    public UAV(UAV uav){
        this.weight = uav.weight;
        this.price = uav.price;
    }

    @Override
    public String toString() {
          return "[UAV]\nThis UAV's weight  "
                + weight + " pounds, and cost " + price + "$.";

    }
}
