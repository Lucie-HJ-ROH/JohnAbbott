import java.util.*;

public class Acrivity01 {
    public static void main(String[] args) {


        System.out.println("--------------------------------");
        System.out.println("This is activity 03");
        missNumber();

        System.out.println("--------------------------------");
        System.out.println("This is activity 05");
        averageSize();
    }


    public static void missNumber() {
        int original[] = new int[10];
        int random[] = new int[9];
        boolean room[] = new boolean[10]; // for preventing duplicate random numbers(1-9)
        int index = 0;
        int rnd;
        int cnt = 1;

        System.out.print("Original   : ");
        for (int i = 0; i < original.length; i++) {
            original[i] = cnt++;
            System.out.print(original[i] + " ");
        }

        System.out.print("\nRandom     : ");
        while (index < 9) {
            rnd = (int) (Math.random() * 10);
            if (!room[rnd]) {
                room[rnd] = true;
                random[index] = rnd + 1;
                System.out.print(random[index] + " ");
                index++;
            }
        }

        int originalTotal = 0;
        int randomTotal = 0;
        for (int i = 0; i <original.length; i++) {
            originalTotal = original[i] + originalTotal;
        }
        for (int j = 0; j < random.length; j++) {
            randomTotal = random[j] + randomTotal;
        }

        System.out.println("\ndifferent number is : " + (originalTotal - randomTotal));

    }

    public static void averageSize(){
        int random[] = new int[10];
        int total = 0;
        int min = 0, max =  0;
        System.out.print("Value : ");
        for (int i = 0; i <random.length; i++) {
            random[i] = (int) (Math.random() * 100);
            System.out.print( + random[i] + " ");
            total = total + random[i];
        }

        



        Arrays.sort(random);
        min = random[0];
        max = random[random.length-1];

        int average = (total-min-max)/(random.length-2);

        System.out.println("\n Average : " + average);

    }


}
