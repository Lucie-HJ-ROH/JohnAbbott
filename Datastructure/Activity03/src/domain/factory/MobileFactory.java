package domain.factory;

import domain.product.mobile.SmartPhone;
import domain.product.tablet.Tablet;

public interface MobileFactory {
    public SmartPhone createSmartPhone(SmartPhone phone);
    public Tablet createTablet(Tablet tablet);
}
