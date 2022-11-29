package q3.factory;

import q3.family.animal.Bear;
import q3.family.animal.Duck;
import q3.family.color.Brown;
import q3.family.color.White;

public class AnimalFactory implements AbstractFactory{


    @Override
    public Object create(Object o) {
        if(o.toString().equals("Duck")) {
            return new Duck();
        }else if (o.toString().equals("Dog")) {
            return new Brown();
        }
        return new Bear();
    }
}
