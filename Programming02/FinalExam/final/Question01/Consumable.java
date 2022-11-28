package Question01;

public class Consumable implements Collectible{

    double itemID;
    String itemName;

    public Consumable(double itemID, String itemName){
        this.itemID = itemID;
        this.itemName = itemName;
    }

    @Override
    public void pickup() {
        System.out.println("Picked up a " + itemName + ".");
    }

    @Override
    public void drop() {
        System.out.println("Dropped up a " + itemName + ".");
    }
}
