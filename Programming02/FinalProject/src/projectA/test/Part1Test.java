package projectA.test;

import projectA.airplane.Airplane;
import projectA.copter.Helicopter;
import projectA.copter.Quadcopter;
import projectA.mav.AgriculturalDrone;
import projectA.mav.MAV;
import projectA.multirotor.Multirotor;
import projectA.uav.UAV;

import java.io.*;

public class Part1Test {
    public static void main(String[] args) throws IOException {
        // create new objects
        Airplane[] airplanes = new Airplane[3];
        Helicopter[] helicopters = new Helicopter[3];
        Quadcopter[] quadcopters = new Quadcopter[3];
        AgriculturalDrone[] agriculturalDrones = new AgriculturalDrone[3];
        MAV[] mav = new MAV[3];
        Multirotor[] multirotors = new Multirotor[3];
        UAV[] uavs = new UAV[3];

        BufferedOutputStream bs = null;
        try {
            bs = new BufferedOutputStream(new FileOutputStream("part1.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1. Create And Display objects. ");
        // initialize objects
        airplanes[0] = new Airplane();
        airplanes[1] = new Airplane("Korean Air", 1500, 2000);
        airplanes[2] = new Airplane(airplanes[1]);

//        for (int i = 0; i < airplanes.length; i++) {
//            System.out.println(airplanes[i].toString());
//        }
        // initialize objects
        helicopters[0] = new Helicopter();
        helicopters[1] = new Helicopter("Heli Coli", 500, 1200, 6, 2015, 4);
        helicopters[2] = new Helicopter(helicopters[1]);

        // initialize objects
        for (int i = 0; i < helicopters.length; i++) {
            System.out.println(helicopters[i].toString());
        }

        // initialize objects
        quadcopters[0] = new Quadcopter();
        quadcopters[1] = new Quadcopter("Quadro Coli", 550, 1600, 7, 2022, 6, 4000);
        quadcopters[2] = new Quadcopter(quadcopters[1]);
//
//        for (int i = 0; i < quadcopters.length; i++) {
//            System.out.println(quadcopters[i].toString());
//        }

        // initialize objects
        agriculturalDrones[0] = new AgriculturalDrone();
        agriculturalDrones[1] = new AgriculturalDrone(300, 2500, "agridron", 10);
        agriculturalDrones[2] = new AgriculturalDrone(agriculturalDrones[1]);
//
//        for (int i = 0; i < agriculturalDrones.length; i++) {
//            System.out.println(agriculturalDrones[i].toString());
//        }
//
        // initialize objects
        mav[0] = new MAV();
        mav[1] = new MAV(290, 3000, "Latest MAV", 100);
        mav[2] = new MAV(mav[1]);
//
//        for (int i = 0; i < mav.length; i++) {
//            System.out.println(mav[i].toString());
//        }

        // initialize objects
        multirotors[0] = new Multirotor();
        multirotors[1] = new Multirotor("Multi-Ro", 10000, 3400, 5, 2021, 10, 5);
        multirotors[2] = new Multirotor(multirotors[1]);
//
//        for (int i = 0; i < multirotors.length; i++) {
//            System.out.println(multirotors[i].toString());
//        }

        //  initialize objects
        uavs[0] = new UAV();
        uavs[1] = new UAV(2500, 3600);
        uavs[2] = new UAV(uavs[1]);
//
//        for (int i = 0; i < uavs.length; i++) {
//            System.out.println(uavs[i].toString());
//        }

        //fist array include UAV class
        Object[] mixFlying = new Object[20];
        mixFlying[0] = airplanes[0];
        mixFlying[1] = airplanes[1];
        mixFlying[2] = airplanes[2];
        mixFlying[3] = helicopters[0];
        mixFlying[4] = helicopters[1];
        mixFlying[5] = helicopters[2];
        mixFlying[6] = quadcopters[0];
        mixFlying[7] = quadcopters[1];
        mixFlying[8] = quadcopters[2];
        mixFlying[9] = multirotors[0];
        mixFlying[10] = multirotors[1];
        mixFlying[11] = multirotors[2];
        mixFlying[12] = agriculturalDrones[0];
        mixFlying[13] = agriculturalDrones[1];
        mixFlying[14] = agriculturalDrones[2];
        mixFlying[15] = mav[0];
        mixFlying[16] = mav[1];
        mixFlying[17] = mav[2];
        mixFlying[18] = uavs[0];
        mixFlying[19] = uavs[1];


        String indroArr1 = "Created first array object,(without UAV class) Display below.\n";
        bs.write(indroArr1.getBytes());


        for (int i = 0; i < mixFlying.length; i++) {
            System.out.println(mixFlying[i].toString());
            try {
                bs.write(mixFlying[i].toString().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        //fist array without UAV class
        Object[] mixAirplane = new Object[16];
        mixAirplane[0] = airplanes[0];
        mixAirplane[1] = airplanes[1];
        mixAirplane[2] = airplanes[2];
        mixAirplane[3] = helicopters[0];
        mixAirplane[4] = helicopters[1];
        mixAirplane[5] = helicopters[2];
        mixAirplane[6] = quadcopters[0];
        mixAirplane[7] = quadcopters[1];
        mixAirplane[8] = quadcopters[2];
        mixAirplane[9] = multirotors[0];
        mixAirplane[10] = multirotors[1];
        mixAirplane[11] = multirotors[2];
        mixAirplane[12] = airplanes[2];
        mixAirplane[13] = helicopters[0];
        mixAirplane[14] = quadcopters[2];
        mixAirplane[15] = multirotors[0];

        String indroArr2 = "\n\nCreated second array object(without UAV class), Display below.\n";
        bs.write(indroArr2.getBytes());

        for (int i = 0; i < mixAirplane.length; i++) {
            System.out.println(mixAirplane[i].toString());
            try {
                bs.write(mixAirplane[i].toString().getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        //Equal Test

        System.out.println("\n2. Equal TEST - ");
        equalTest(airplanes[1], airplanes[2]); // same test
        equalTest(quadcopters[1], helicopters[1]); // different class
        equalTest(agriculturalDrones[1], agriculturalDrones[0]); // different object
        equalTest(mav[1], uavs[1]); // different class

//        System.out.println("1. Airplane[1] VS Airplane[2] , Airplane[1] VS Helicopter[1]");
//
//        if (airplanes[1].equals(airplanes[2])) {
//            System.out.println("airplanes[1] and airplanes[2] are same.");
//        } else {
//            System.out.println("airplanes[1] and airplanes[2] are not same.");
//        }
//
//        if (airplanes[1].equals(helicopters[1])) {
//            System.out.println("airplanes[1] and helicopters[1] are same.");
//        } else {
//            System.out.println("airplanes[1] and helicopters[1] are not same.");
//        }
//
//        System.out.println("2. Multilator[1] VS Multilator[2] , Multilator[1] VS AgriculturalDrone[1]");
//
//        if (multirotors[1].equals(multirotors[2])) {
//            System.out.println("multirotors[1] and multirotors[2] are same.");
//        } else {
//            System.out.println("multirotors[1] and multirotors[2] are not same.");
//        }
//
//        if (multirotors[1].equals(agriculturalDrones[1])) {
//            System.out.println("multirotors[1] and agriculturalDrones[1] are same.");
//        } else {
//            System.out.println("multirotors[1] and agriculturalDrones[1] are not same.");
//        }


        String findMaxMin = "\n\n3.Find least and most expensive UAV - 1st Array (without UAV) ";
        bs.write(findMaxMin.getBytes());
        String maxMinResult = "";
        System.out.println("\n3.Find least and most expensive UAV - 1st Array (without UAV) ");
        //If array is empty, make null point exception error.
        try {
            maxMinResult = findLeastAndMostExpensiveUAV(mixAirplane); // without UAV
            System.out.println(maxMinResult);
            bs.write(maxMinResult.getBytes());
        } catch (NullPointerException e) {
            System.out.println("We can't find any Object. It's null.");
        }


        String findMaxMin2 = "\n\n3.Find least and most expensive UAV - 2st Array (with UAV) ";
        bs.write(findMaxMin2.getBytes());
        System.out.println("\n3.Find least and most expensive UAV - 2st Array (with UAV) ");
        //If array is empty, make null point exception error.
        try {
            maxMinResult = findLeastAndMostExpensiveUAV(mixFlying); // without UAV
            System.out.println(maxMinResult);
            bs.write(maxMinResult.getBytes());
        } catch (NullPointerException e) {
            System.out.println("\nWe can't find any Object. It's null.");
        }

        bs.close();


    }

    public static void equalTest(Object o1, Object o2) {
        if (o1.equals(o2)) {
            System.out.println("Two object are exactly same.");
        } else {
            System.out.println("Tow object are different");
        }
    }

    public static String findLeastAndMostExpensiveUAV(Object[] obj) {

        UAV max = null;
        UAV min = null;

        UAV tempMax = null;
        UAV tempMin = null;

        StringBuffer s= new StringBuffer();

        String result = "";

        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof UAV) {
                s.append("\n" + ((UAV) obj[i]).price);
                for (int j = i + 1; j < obj.length; j++) {
                    if (obj[j] instanceof UAV) {
                        if (tempMax == null && ((UAV) obj[i]).price < ((UAV) obj[j]).price) {
                            max = (UAV) obj[j];
                            tempMax = max;
                        } else if (((UAV) obj[i]).price < ((UAV) obj[j]).price && tempMax.price < ((UAV) obj[j]).price) {
                            max = (UAV) obj[j];
                            tempMax = max;
                        }

                        if (tempMin == null && ((UAV) obj[i]).price > ((UAV) obj[j]).price) {
                            min = (UAV) obj[j];
                            tempMin = min;
                        } else if (((UAV) obj[i]).price > ((UAV) obj[j]).price && tempMin.price > ((UAV) obj[j]).price) {
                            min = (UAV) obj[j];
                            tempMin = min;
                        }
                    }

                }

            }
        }

        if (max != null || min != null) {
            result = "\n" + max.toString() + "\n" + min.toString();
            s.append(result);
        } else {
            result = "\nWe can't find UAV.";
            s.append(result);
        }

        return s.toString();
    }


}
