package activity02;

public class UtilizeCellPhones {
    public static void main(String[] args) {
        CellPhone c1 = new CellPhone();
        CellPhone c2 = new CellPhone("Samsung" , 500);
        CellPhone c3 = new CellPhone(c1);


        System.out.println("====================Initial Information===================");
        c1.showInfo();
        c2.showInfo();
        c3.showInfo();


        /**
         * Change the price of the first object;
         * the price and the brand of the second object,
         * and the serial number value of the third object.
         * and the serial number value of the third object.
         * ==> Since changing the serial number arbitrarily can affect the program,
         *     it is designed not to be changed arbitrarily.
         */

        System.out.println("====================Change Information===================");
        c1.setPrice(990);
        c2.setBrand("Apple");
        c2.setPrice(1500);


        /*
        * */

        System.out.println("change price of c1 to " + c1.getPrice() + "$ ");
        System.out.println("change brand of c2 to " + c2.getBrand() + " and price  " + c2.getPrice() + "$ ");

        System.out.println("====================Price Information===================");
        System.out.printf("The price of c1 is %.2f", c1.getPrice());
        System.out.printf("\nThe price of c1 is %.2f", c2.getPrice());
        System.out.printf("\nThe price of c1 is %.2f", c3.getPrice());


        System.out.println("\n====================Check the same phone among objects ===================");


        // make c2 and c3 same.
        c3.setPrice(1500);
        c3.setBrand("Apple");


        if(c1.equals(c2)){
            System.out.println("c1 and c2 is same.");
        }else if(c1.equals(c3)){
            System.out.println("c1 and c3 is same.");
        }else if(c2.equals(c3)){
            System.out.println("c2 and c3 is same.");
        }else{
            System.out.println("There are no same phone.");
        }





    }
}
