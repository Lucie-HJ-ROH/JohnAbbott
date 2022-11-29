package session08;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO01 {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("a.txt", true));
        } catch (FileNotFoundException e) {
            System.out.println("There is no file.");
            System.exit(0);
        }

        System.out.println("Give me your name? ");
        String s = kb.next();
        pw.println(s);

        System.out.println("Give me your address? ");
        String ss = kb.next();
        pw.println(ss);

        System.out.println("Give me your address? 2 ");
        String sss = kb.next();
        pw.println(sss);

        pw.close();
    }

}
