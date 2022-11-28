package factoryPattern;

public abstract class CarFactory {
    public abstract Car createCar(String name);

    public abstract Car returnCar(String name);
    public void numbering(){
        System.out.println("Numbering");
    }

    public void washCar(){
        System.out.println("Wash Car");
    }
    final public void sellCar(String name){
        numbering();
        washCar();
        createCar(name);
    }
}
