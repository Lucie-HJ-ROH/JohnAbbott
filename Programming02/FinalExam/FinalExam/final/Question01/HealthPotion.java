package Question01;

public class HealthPotion extends Consumable{
    int healthRestore;

    public HealthPotion(double itemId, String itemName, int healthRestore){
        super(itemId, itemName);
        this.healthRestore = healthRestore;
    }

}
