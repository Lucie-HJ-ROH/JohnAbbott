package q3.factory;

import q3.family.animal.Duck;
import q3.family.color.Black;
import q3.family.color.Brown;
import q3.family.color.White;

public class ColorFactory implements AbstractFactory{

    @Override
    public Object create(Object o) {
        if(o.toString().equals("White")) {
            return new White();
        } else if (o.toString().equals("Brown")) {
            return new Brown();
        }

        return new Black();
    }
}
