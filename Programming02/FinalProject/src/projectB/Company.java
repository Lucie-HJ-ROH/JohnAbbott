package projectB;

import java.io.*;
import java.util.Scanner;

public class Company {

    public static void main(String[] args) {

        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("Employee.txt "));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\nInput the add employee , How many employee do you want to add ?  ");
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();


        Employee[] employee = new Employee[num];
        //Make employee constructor.
 //       System.out.println("<<<<<<<<<<<<10 employees are completely constructed.>>>>>>>>>>>>>");
//        employee[0] = new Employee("Kim", new Date(12, 20, 2001), "manager"); // normal case
//        employee[1] = new Employee("Lee", new Date(1, 50, 2010), "step");  // error in day
//        employee[2] = new Employee("One", new Date(12, 1, 99), "marketer"); // error in year
//        employee[3] = new Employee("Two", new Date(13, 20, 2022), "junior"); // error in month
//        employee[4] = new Employee("Three", new Date(1, 11, 2010), "senior"); // normal case
//        employee[5] = new Employee("Four", new Date(2, 12, 2015), "manager"); // normal case
//        employee[6] = new Employee("Five", new Date(3, 13, 2016), "step");  // error in day
//        employee[7] = new Employee("Six", new Date(4, 14, 2017), "marketer"); // error in year
//        employee[8] = new Employee("Seven", new Date(5, 15, 2018), "junior"); // error in month
//        employee[9] = new Employee("Eight", new Date(6, 16, 2021), "senior"); // normal case

        for (int i = 0; i < num; i++) {
            System.out.print(" name : ");
            String name = kb.next();
            System.out.print(" month : ");
            int month = kb.nextInt();
            System.out.print(" day : ");
            int day = kb.nextInt();
            System.out.print(" year : ");
            int year = kb.nextInt();
            System.out.print(" position : ");
            String position = kb.next();
            employee[i] = new Employee(name, new Date(month, day, year), position);
            System.out.println("# " + (i+1)+ " employee is created");
        }

        for (int i = 0; i <num ; i++) {
            System.out.println(employee[i].toString());
        }





        System.out.println("Employee.txt file is created.");
        //write file
        for (Employee e:employee
             ) {
            writeToFile(e.toString());
        }


        System.out.println("Employee.txt file is loaded.  Show the inside of Employee.txt file");
        //readFile
        readToFile(sc);

        System.out.println("If you find specific employee put the date. : ");


        System.out.print("Input the year: ");
        int findYear = kb.nextInt();
        System.out.print("Input the month: ");
        int findMonth = kb.nextInt();
        System.out.print("Input the day: ");
        int findDay = kb.nextInt();

        findEmployee(employee, findYear, findMonth, findDay);


    }

    public static void findEmployee(Employee[] employee, int year, int month, int day) {

        int count = 0;
        System.out.println("Find employees hired after a particular Date.");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].hiredDate.year > year){
                System.out.println(employee[i]);
            }else if(employee[i].hiredDate.year == year && employee[i].hiredDate.month > month ){
                System.out.println(employee[i]);
            }else if(employee[i].hiredDate.year == year && employee[i].hiredDate.month == month && employee[i].hiredDate.day>=day){
                System.out.println(employee[i]);
            }
        }

    }

    public static void writeToFile(String str) {
        // save the employee in the file.

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream("Employee.txt ", true));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.println(str);
        pw.close();
    }

    public static void readToFile(Scanner sc) {
        // save the employee in the file.
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

    }
}
