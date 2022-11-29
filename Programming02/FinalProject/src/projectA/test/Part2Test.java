package projectA.test;

import projectA.airplane.Airplane;
import projectA.copter.Helicopter;
import projectA.copter.Quadcopter;
import projectA.mav.AgriculturalDrone;
import projectA.mav.MAV;
import projectA.multirotor.Multirotor;
import projectA.uav.UAV;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Part2Test {

    public static void main(String[] args) throws IOException {
        // create new objects
        Airplane[] airplanes = new Airplane[3];
        Helicopter[] helicopters = new Helicopter[3];
        Quadcopter[] quadcopters = new Quadcopter[3];
        AgriculturalDrone[] agriculturalDrones = new AgriculturalDrone[3];
        MAV[] mav = new MAV[3];
        Multirotor[] multirotors = new Multirotor[3];
        UAV[] uavs = new UAV[3];



        System.out.println("1. Create And Display objects. ");
        // initialize objects
        airplanes[0] = new Airplane();
        airplanes[1] = new Airplane("Korean Air", 1500, 2000);
        airplanes[2] = new Airplane(airplanes[1]);

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

        // initialize objects
        agriculturalDrones[0] = new AgriculturalDrone();
        agriculturalDrones[1] = new AgriculturalDrone(300, 2500, "agridron", 10);
        agriculturalDrones[2] = new AgriculturalDrone(agriculturalDrones[1]);
        // initialize objects
        mav[0] = new MAV();
        mav[1] = new MAV(290, 3000, "Latest MAV", 100);
        mav[2] = new MAV(mav[1]);

        // initialize objects
        multirotors[0] = new Multirotor();
        multirotors[1] = new Multirotor("Multi-Ro", 10000, 3400, 5, 2021, 10, 5);
        multirotors[2] = new Multirotor(multirotors[1]);
        //  initialize objects
        uavs[0] = new UAV();
        uavs[1] = new UAV(2500, 3600);
        uavs[2] = new UAV(uavs[1]);

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

        BufferedOutputStream bs = null;
        try {
            bs = new BufferedOutputStream(new FileOutputStream("part2-original.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String indroArr1 = "Created first array object Display original array below.\n";
        bs.write(indroArr1.getBytes());

        String enter = "\n";
        bs.write(enter.getBytes());
        for (int i = 0; i < mixFlying.length; i++) {
            System.out.println(mixFlying[i].toString());
            try {
                bs.write(mixFlying[i].toString().getBytes());
                bs.write(enter.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        BufferedOutputStream bs2 = null;
        try {
            bs2 = new BufferedOutputStream(new FileOutputStream("part2-copy.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Object[] copyArr = copyFlyingObjects(mixFlying);

        String indroArr2 = "copied first array object Display copied array below.\n";
        bs2.write(indroArr2.getBytes());
        bs.write(enter.getBytes());

        for (int i = 0; i < copyArr.length; i++) {
            System.out.println(copyArr[i].toString());
            try {
                bs2.write(copyArr[i].toString().getBytes());
                bs2.write(enter.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        bs.close();
        bs2.close();

    }

    public static Object[] copyFlyingObjects(Object[] obj){

        Object[] copy = new Object[obj.length];

        for (int i = 0; i <obj.length ; i++) {
            copy[i] = obj[i];
        }
        return copy;

    }
}
