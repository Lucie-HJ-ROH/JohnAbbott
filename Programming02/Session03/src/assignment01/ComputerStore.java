package assignment01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Assignment01
 * Hyunju Roh
 * Written by : Hyunju Roh 2227572
 */
public class ComputerStore {
    static final String PASSWORD = "password"; // this is the password for the owner of computer store.
    int maxComputers = 0; // maximum number of computers.
    Computer[] inventory; // for tracking of the created computer object.
    Scanner kb = new Scanner(System.in);

    public ComputerStore(){ // constructor with maximum number of computers.
        System.out.print("Input the maximum number of computers: ");
        maxComputers = kb.nextInt();
        inventory = new Computer[maxComputers];
    }
    public void tryMainMenuOption() { // display and select main menu
        printMainMenu();
        int option = kb.nextInt(); // choice the option of main menu
        do {                        //Keep prompting until the user enter the number between 1-5.
            mainMenu(option);
            option = kb.nextInt();
        } while (option != 5);

    }

    public void tryUpdateMenuOption(int index) { // display and select update menu
        printUpdateMenu();
        int option = kb.nextInt(); // choice the option of update menu
        do {                        //Keep prompting until the user enter the number between 1-5.
            updateMenu(option,index);
            option = kb.nextInt();
        } while (option != 5);

    }
    public void printMainMenu() {

        System.out.println("\nWhat do you want to do?\n");
        System.out.println("    1.  Enter new computers (password required)");
        System.out.println("    2.  Change information of a computer (password required)");
        System.out.println("    3.  Display all computers by a specific brand");
        System.out.println("    4.  Display all computers under a certain a price.");
        System.out.println("    5.  Quit");
        System.out.print("\nPlease enter your choice : ");
    }

    public void printUpdateMenu() {

        System.out.println("\nWhat information would you like to change?\n");
        System.out.println("    1.  brand");
        System.out.println("    2.  model");
        System.out.println("    3.  SN");
        System.out.println("    4.  price");
        System.out.println("    5.  Quit (Go To Main Menu)");
        System.out.print("\nEnter your choice : ");

    }

    public void mainMenu(int option) {
        //each method is called by the option.
        switch (option) {
            case 1:
                mainOption01();
                break;
            case 2:
                mainOption02();
                break;
            case 3:
                mainOption03();
                break;
            case 4:
                mainOption04();
                break;
            case 5:
                System.out.println("\n============Thank you for visiting my store. See you!===============\n");
                System.exit(0);
                break;

            default:
                System.out.print("Invalid Number , Please input again :");

        }

    }
    public void updateMenu(int option,int index) {
        //each method is called by the option.
        switch (option) {
            case 1:
                System.out.print("Enter the update brand name : ");
                String newBrand = kb.next();
                inventory[index].setBrand(newBrand); // change brand
                break;
            case 2:
                System.out.print("Enter the update model name : ");
                String newModel = kb.next();
                inventory[index].setModel(newModel);// change model name
                break;
            case 3:
                System.out.print("Enter the update serial number  : ");
                long newSerial = kb.nextLong();
                inventory[index].setSerialNumber(newSerial); // change serial number
                break;
            case 4:
                System.out.print("Enter the update price  : ");
                int newPrice = kb.nextInt();
                inventory[index].setPrice(newPrice); // change price
                break;
            case 5:
                tryMainMenuOption(); // return to main menu instead of system quit.
                break;
            default:
                System.out.print("Invalid Number , Please input again :");

        }
        showInventory(index); // show all attribute after changed
        tryUpdateMenuOption(index); // try again until enter number 5.
    }

    public void mainOption01() {
        boolean checkPwd = passwordCheck(); // boolean value wheather the password correct or not

        if (checkPwd) { // password check
            System.out.print("How many computer do you want to enter : ");
            int addCom = kb.nextInt(); // the number which user want to add to the array inventory
            addComputer(addCom); // call add inventory array
        } else {
            System.out.print("Password is incorrect more than 3 times.");
            tryMainMenuOption(); // call display and select main menu
        }
    }

    public void mainOption02(){
        boolean checkPwd = passwordCheck(); // boolean value wheather the password correct or not
        if (checkPwd) { // password check
            System.out.print("Which computer number you wish to update?  ");
            int index = kb.nextInt(); // the number which user want to add to the array inventory
            updateComputer(index); // call add inventory array
        } else {
            System.out.println("Password is incorrect more than 3 times.");
            tryMainMenuOption(); // call display and select main menu
        }
    }

    public void mainOption03(){
        System.out.print("Input the brand name you are looking for : ");
        String findBrand = kb.next();
        ArrayList<Computer> comList = findComputersBy(findBrand);
        System.out.println("\n==================Find brand List==========================\n");
        for (int i = 0; i <comList.size() ; i++) {
            System.out.println(comList.get(i));
        }
        System.out.printf("\n=====================We fonnd %d computers==================\n",comList.size());
        tryMainMenuOption();
    }

    public void mainOption04(){
        System.out.print("Input the price which you are looking for : ");
        double findPrice = kb.nextDouble();
        ArrayList<Computer> comList = findCheaperComputersThan(findPrice);
        System.out.println("\n=====================Cheaper price List==================\n");
        for (int i = 0; i <comList.size() ; i++) {
             System.out.println(comList.get(i));
        }
        System.out.printf("\n=====================We fonnd %d computers==================\n",comList.size());
        tryMainMenuOption();
    }
    /**
     * Add inventory
     *
     * @param num
     */
    public void addComputer(int num) {
        int remain = maxComputers - Computer.findNumberOfCreatedComputers(); // number of remain place in inventory array.
        int inventoryCount = Computer.findNumberOfCreatedComputers();// count of created computer

        if (num > remain) { // there are no room for add. display main menu
            System.out.println("\nError!!!! You can't add the computer.");
            System.out.printf("----> You can remain only << %d >> spaces in array. \n", remain);
        } else {
            if (inventoryCount == 0) { // if item is first added, the end of for loof is num
                for (int i = inventoryCount; i < num; i++) {
                    inventory[i] = new Computer("Apple", "MacBook Pro", 4000);
                }
            } else {
                for (int i = inventoryCount; i < num + inventoryCount; i++) {
                    inventory[i] = new Computer("LG", "Gram", 2000);
                }
            }
        }
        tryMainMenuOption(); // after finishing adding items, return main menu
    }
    public void updateComputer(int index){
        int currentCom = Computer.findNumberOfCreatedComputers();
        if(index>currentCom){
            System.out.print("\nError ! This index number is invald. \n");
        }else{
            showInventory(index);
            tryUpdateMenuOption(index);
        }
        tryMainMenuOption(); // call display and select main menu
    }

    public void showInventory(int index){
        System.out.println("Computer # " + index);
        System.out.println("Brand : " + inventory[index].getBrand());
        System.out.println("Computer Model : " + inventory[index].getModel());
        System.out.println("Serial Number : " + inventory[index].getSerialNumber());
        System.out.println("Computer Price : $" + inventory[index].getPrice());
    }

    /**
     * password is 'password'
     * @return
     */
    public boolean passwordCheck() {
        System.out.print("Enter the password : ");
        String password;
        int cnt = 0; // count incorrect password
        do {
            password = kb.next();
            if (password.equals(PASSWORD)) {
                return true;
            } else {
                System.out.print("Incorrect password try again : ");
                cnt++; // increase incorrect count

            }
        } while (cnt < 3); // only for 3 times tries to enter the incorrect password

        return false;
    }

    public ArrayList<Computer> findComputersBy (String brand){
        ArrayList<Computer> com = new ArrayList<>(); //find array and save into the arraylist
        int remain = Computer.findNumberOfCreatedComputers(); // created inventory.
        for (int i = 0; i < remain ; i++) {
            if(brand.equals(inventory[i].getBrand())){
                com.add(inventory[i]);
            }
        }
        return com;
    }

    public ArrayList<Computer> findCheaperComputersThan (double price){
        ArrayList<Computer> com = new ArrayList<>();//find array and save into the arraylist
        int remain = Computer.findNumberOfCreatedComputers(); // created inventory.
        for (int i = 0; i < remain ; i++) {
            if(price>inventory[i].getPrice()){
                com.add(inventory[i]);
            }
        }
        return com;
    }


}
