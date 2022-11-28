package Question01;

public class ManaPotion extends Consumable {

    int manaRestored;

    public ManaPotion(double itemId, String itemName, int manaRestored) {
        super(itemId, itemName);
        this.manaRestored = manaRestored;
    }
}
