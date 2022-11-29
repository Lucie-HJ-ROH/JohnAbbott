package q3;

import q3.factory.AbstractFactory;
import q3.factory.AnimalFactory;
import q3.factory.ColorFactory;
import q3.family.animal.Animal;
import q3.family.animal.Bear;
import q3.family.animal.Dog;
import q3.family.animal.Duck;
import q3.family.color.Black;
import q3.family.color.Brown;
import q3.family.color.Color;
import q3.family.color.White;

import java.util.Scanner;

public class FactoryProvider {

    public void choiceFactory() {
        AbstractFactory abstractFactory = null;
        Animal animal = null;
        Color color = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("        Choose the factory ");
        System.out.println("        1. Animal   ");
        System.out.println("        2. Color   ");
        System.out.println("        3. Exit   ");
        System.out.println("================================================");
        System.out.println("Input Number your choice");
        int choice = sc.nextInt();
        if (choice == 3) {
            System.out.println("Thank you for visiting, See you again!");
            System.exit(1);
        }
        String factory = choice == 1 ? "Animal" : "Color";
        if (factory.equals("Animal")) {
            System.out.println("================================================");
            System.out.println("        Choose the Animal   ");
            System.out.println("        1. Duck   ");
            System.out.println("        2. Dog   ");
            System.out.println("        3. Bear   ");
            System.out.println("        4. Exit   ");
            System.out.println("================================================");

            System.out.println("Input Number your choice");
            int animalChoice = sc.nextInt();

            System.out.println("Animal choice is " + animalChoice);

            if (animalChoice == 4) {
                System.out.println("Thank you for visiting, See you again!");
                System.exit(1);
            }

            abstractFactory = new AnimalFactory();
            if(animalChoice == 1){
                Duck duck = new Duck();
                animal = (Animal) abstractFactory.create(duck);
            }else if (animalChoice == 2) {
                Dog dog = new Dog();
                animal = (Animal) abstractFactory.create(dog);

            }else{
                Bear bear = new Bear();
                animal = (Animal) abstractFactory.create(bear);

            }
            System.out.println("Type of animal : " + animal.getType());
            System.out.println("Sound of animal : " + animal.makeSound());

        }
        if (factory.equals("Color")) {
            System.out.println("================================================");
            System.out.println("        Choose the Animal   ");
            System.out.println("        1. White   ");
            System.out.println("        2. Brown   ");
            System.out.println("        3. Black   ");
            System.out.println("        4. Exit   ");
            System.out.println("================================================");

            System.out.println("Input Number your choice");
            int colorChoice = sc.nextInt();

            if (colorChoice == 4) {
                System.out.println("Thank you for visiting, See you again!");
                System.exit(1);
            }

            abstractFactory = new ColorFactory();
            if(colorChoice == 1){
                White white = new White();
                color = (Color) abstractFactory.create(white);
            } else if (colorChoice == 2) {
                Brown brown = new Brown();
                color = (Color) abstractFactory.create(brown);

            }else{
                Black black = new Black();
                color = (Color) abstractFactory.create(black);

            }
            System.out.println("Type of color : " + color.getColor());
        }

    }
//
//
//    public AbstractFactory getFactory() {
//
//        if (factory.equals("Animal")) {
//            return new Animal();
//        }
//        return new Color();
//
//    }
}
