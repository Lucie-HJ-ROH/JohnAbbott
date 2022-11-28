package Question01;

public class MainClass {

    public static void main(String[] args) {

        Collectible collectibles[] = new Collectible[5];

        collectibles[0] = new Gold(30);
        collectibles[1] = new Gold(15);
        collectibles[2] = new HealthPotion(40000,"Minor Health Potion", 10);
        collectibles[3] = new HealthPotion(4100, "Large Health Potion" , 100);
        collectibles[4] = new ManaPotion(5000, "Mediup Mana Potion", 50);


        for (Collectible coll : collectibles) {
            coll.pickup();
            coll.drop();
        }
    }
}
