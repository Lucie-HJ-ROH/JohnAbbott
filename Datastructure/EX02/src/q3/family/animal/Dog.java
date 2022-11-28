package q3.family.animal;

public class Dog implements Animal{
    @Override
    public String getType() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Bark";
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
