package session02e2;
public class Vehicle {

    //Attributes
    private int numOfDoor;
    private double price ;
    private int maxSpeed;

    //constructor
    public Vehicle() {
        System.out.println("new object created");
        numOfDoor = 4;
        price = 10000;
        maxSpeed = 300;
    }

    //Methods

    public int getNumOfDoor() {
        return numOfDoor;
    }


    public void setNumOfDoor(int nd) {
        if(nd>2 && nd<6) {
            numOfDoor = nd;
        }
        else {
            System.out.println("this is not valid number of the door");
        }
    }


    public double price() {
        return price;
    }

    public void setPrice(double pr) {
        if(pr > 1000 && pr < 60000) {
            price = pr;
        }else {
            System.out.println("this is not valid price");
        }
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int max) {
        if(max > 80 && max < 300) {
            maxSpeed = max;
        }else {
            System.out.println("this is not valid maximum speed");
        }
    }

    public void showInfo() {
         System.out.println("The vehicle has " +numOfDoor + " door,  maximum speed is " +maxSpeed + " km/h , price is " + price+ " $. " );
    }


    public boolean equal(Vehicle v) {

        if(numOfDoor == v.numOfDoor && price == v.price &&  maxSpeed == v.maxSpeed) {
            return true;
        }else {
            return false;
        }
    }

}
