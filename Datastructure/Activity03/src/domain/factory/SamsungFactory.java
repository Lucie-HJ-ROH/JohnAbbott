package domain.factory;

import domain.product.mobile.SmartPhone;
import domain.product.mobile.apple.Iphone6;
import domain.product.mobile.apple.Iphone6Plus;
import domain.product.mobile.samsung.GalaxyJ7;
import domain.product.mobile.samsung.GalaxyOn7;
import domain.product.tablet.Tablet;
import domain.product.tablet.apple.IpadMini4;
import domain.product.tablet.apple.IpadPro;
import domain.product.tablet.samsung.GalaxyTabA;
import domain.product.tablet.samsung.GalaxyTabS2;

public class SamsungFactory implements MobileFactory{
    @Override
    public SmartPhone createSmartPhone(SmartPhone phone) {
        if (phone.toString().equals("GalaxyJ7")) {
            return new GalaxyJ7();
        }

        return new GalaxyOn7();


    }

    @Override
    public Tablet createTablet(Tablet tablet) {
        if (tablet.toString().equals("GalaxyTabS2")) {
            return new GalaxyTabS2();
        }

        return new GalaxyTabA();
    }
}
