package q3.family.animal;

public class Duck implements Animal{
    @Override
    public String getType() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Quack";
    }

    @Override
    public String toString() {
        return "Duck";
    }
}
