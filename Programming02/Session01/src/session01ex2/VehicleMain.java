package session01ex2;
import java.util.Scanner;

public class VehicleMain {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle();
        Vehicle v3 = new Vehicle();

        System.out.println("Initial information of v1 is as follow :\n==================================");
        v1.showInfo();
        System.out.println("\nInitial information of v2 is as follow :\n==================================");
        v2.showInfo();
        System.out.println("\nInitial information of v3 is as follow :\n==================================");
        v3.showInfo();

        v1.setNumOfDoor(4);
        v1.setPrice(10000);
        v1.setMaxSpeed(200);

        v2.setNumOfDoor(7);
        v2.setPrice(25000);
        v2.setMaxSpeed(300);

        v3.setNumOfDoor(5);
        v3.setPrice(30000);
        v3.setMaxSpeed(250);

        System.out.println("Enter the maximum price, minimum number of door, and minimum speed of your vehicle. You want to pay it :  : ");

        double price;
        int nDoor;
        int maxSpeed;
        System.out.print("Price : ");
        price = kb.nextDouble();

        System.out.print("Number of door : ");
        nDoor = kb.nextInt();

        System.out.print("Number of maximum speed : ");
        maxSpeed = kb.nextInt();



    }

}
