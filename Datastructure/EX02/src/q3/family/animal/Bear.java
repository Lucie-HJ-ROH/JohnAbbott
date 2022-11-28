package q3.family.animal;

public class Bear implements Animal{
    @Override
    public String getType() {
        return "Bear";
    }

    @Override
    public String makeSound() {
        return "Ourrrrrs";
    }

    @Override
    public String toString() {
        return "Bear";
    }
}
