package domain.factory;

import domain.product.mobile.SmartPhone;
import domain.product.mobile.apple.Iphone6;
import domain.product.mobile.apple.Iphone6Plus;
import domain.product.tablet.Tablet;
import domain.product.tablet.apple.IpadMini4;
import domain.product.tablet.apple.IpadPro;

public class AppleFactory implements MobileFactory {
    @Override
    public SmartPhone createSmartPhone(SmartPhone phone) {
        if (phone.toString().equals("Iphone6")) {
            return new Iphone6();
        }

        return new Iphone6Plus();


    }

    @Override
    public Tablet createTablet(Tablet tablet) {
        if (tablet.toString().equals("IpadMini4")) {
            return new IpadMini4();
        }

        return new IpadPro();
    }
}
