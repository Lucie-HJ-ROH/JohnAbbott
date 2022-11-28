package factoryPattern;

public class CarTest {


    public static void main(String[] args) {
        CarFactory carFactory = new HyundaiCarFactory();
        Car newCar = carFactory.createCar("sonata");
        System.out.println(newCar);
        Car myCar = carFactory.returnCar("Tomas");

        Car hisCar = carFactory.returnCar("Tomas");

        System.out.println(myCar == hisCar);

    }



}
