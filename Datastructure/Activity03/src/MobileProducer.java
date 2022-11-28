import domain.factory.AppleFactory;
import domain.factory.MobileFactory;
import domain.factory.SamsungFactory;
import domain.product.Product;
import domain.product.mobile.SmartPhone;
import domain.product.mobile.apple.Iphone6;
import domain.product.mobile.apple.Iphone6Plus;
import domain.product.mobile.samsung.GalaxyJ7;
import domain.product.mobile.samsung.GalaxyOn7;
import domain.product.tablet.Tablet;
import domain.product.tablet.apple.IpadMini4;
import domain.product.tablet.apple.IpadPro;
import domain.product.tablet.samsung.GalaxyTabA;
import domain.product.tablet.samsung.GalaxyTabS2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileProducer {
    Scanner scanner = new Scanner(System.in);
//
//    List<SmartPhone> products = new ArrayList<SmartPhone>();
//
//    public void addProductDetail(Product product){
//        products.add(product);
//    }

    public void choiceCompany(){
        System.out.println("================================================");
        System.out.println("        Choice the mobile company   ");
        System.out.println("        1. Apple   ");
        System.out.println("        2. Samsung   ");
        System.out.println("        3. Exit   ");
        System.out.println("================================================");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Number your choice");
        int choice = scanner.nextInt();
        if(choice == 3){
            System.out.println("Thank you for visiting, See you again!");
            System.exit(1);
        }
        String company = choice==1?"Apple":"Samsung";
        System.out.println(" You choose the : " + company);
        choiceMobileAppliance(company);

    }
    public void choiceMobileAppliance(String company){
        System.out.println("================================================");
        System.out.println("        Choice the mobile appliance   ");
        System.out.println("        1. Tablet   ");
        System.out.println("        2. SmartPhone   ");
        System.out.println("        3. Exit   ");
        System.out.println("================================================");

        System.out.println("Input Number your choice");
        int choice = scanner.nextInt();

        if(choice == 3){
            System.out.println("Thank you for visiting, See you again!");
            System.exit(1);
        }
        String appliance = choice==1?"Tablet":"SmartPhone";
        System.out.println(" You choose the : " + appliance);
        if(appliance.equals("Tablet")){
            choiceTabletModel(company);
        }else{
            choiceSmartphoneModel(company);
        }

    }

    public void choiceSmartphoneModel(String company){

        System.out.println("================================================");
        System.out.println("        Choose the Smart Phone   ");

        if(company.equals("Apple")) {

            System.out.println("        1. Iphone6   ");
            System.out.println("        2. Iphone6Plus   ");

        }else{
            System.out.println("        1. GalaxyJ7   ");
            System.out.println("        2. GalaxyOn7   ");
        }
        System.out.println("        3. Exit   ");
        System.out.println("================================================");

        System.out.println("Input Number your choice");
        int choice = scanner.nextInt();

        if(choice == 3){
            System.out.println("Thank you for visiting, See you again!");
            System.exit(1);
        }

        String model;
        MobileFactory mobileFactory = null;
        SmartPhone smartPhone = null;
        if(company.equals("Apple")){
            mobileFactory = new AppleFactory();
            if(choice == 1){
                Iphone6 iphone6 = new Iphone6();
                 smartPhone = mobileFactory.createSmartPhone(iphone6);

            }else{
                Iphone6Plus iphone6Plus = new Iphone6Plus();
                 smartPhone = mobileFactory.createSmartPhone(iphone6Plus);
            }
        }
        else if(company.equals("Samsung")){
            mobileFactory = new SamsungFactory();
            if(choice == 1){
                GalaxyJ7 galaxyJ7 = new GalaxyJ7();
                 smartPhone = mobileFactory.createSmartPhone(galaxyJ7);

            }else{
                GalaxyOn7 galaxyOn7 = new GalaxyOn7();
                 smartPhone = mobileFactory.createSmartPhone(galaxyOn7);
            }
        }else{
            System.out.println("Error Unknown");
        }


        System.out.print("Your Choice is : ");
        System.out.println(smartPhone.info());
    }


    public void choiceTabletModel(String company){

        System.out.println("================================================");
        System.out.println("        Choose the tablet    ");

        if(company.equals("Apple")) {

            System.out.println("        1. IpadMini4   ");
            System.out.println("        2. IpadPro   ");

        }else{
            System.out.println("        1. GalaxyTabA   ");
            System.out.println("        2. GalaxyTabS2  ");
        }
        System.out.println("        3. Exit   ");
        System.out.println("================================================");

        System.out.println("Input Number your choice");
        int choice = scanner.nextInt();

        if(choice == 3){
            System.out.println("Thank you for visiting, See you again!");
            System.exit(1);
        }

        String model;
        MobileFactory mobileFactory = null;
        Tablet tablet = null;
        if(company.equals("Apple")){
            mobileFactory = new AppleFactory();
            if(choice == 1){
                IpadMini4 ipadMini4 = new IpadMini4();
                tablet = mobileFactory.createTablet(ipadMini4);

            }else{
                IpadPro ipadPro = new IpadPro();
                tablet = mobileFactory.createTablet(ipadPro);
            }
        }
        else if(company.equals("Samsung")){
            mobileFactory = new SamsungFactory();
            if(choice == 1){
                GalaxyTabA galaxyTabA = new GalaxyTabA();
                tablet = mobileFactory.createTablet(galaxyTabA);

            }else{
                GalaxyTabS2 galaxyTabS2 = new GalaxyTabS2();
                tablet = mobileFactory.createTablet(galaxyTabS2);
            }
        }else{
            System.out.println("Error Unknown");
        }


        System.out.print("Your Choice is : ");
        System.out.println(tablet.info());
    }

}
