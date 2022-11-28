package Question03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AppendData {
    public static void main(String[] args) {

        /**
         * How would you append data to the end of a file? Create an object from the class you would use.
         */
        PrintWriter pw = null;
        Scanner kb = new Scanner(System.in);
        try { //true means append the data in append.txt
            pw = new PrintWriter(new FileOutputStream("append.txt ",true));
            // if we put the true in FileOutputStream's second parameter, it means we will append our next data
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e2){
            System.out.println(e2.getMessage());
        }

        System.out.println("Something input in this text :  ");
        String s = kb.nextLine();
        pw.println(s);

        pw.close();


    }
}
