package Question01;

public class Gold implements Collectible{
    int value;

    public Gold(int value){
        this.value = value;
    }
    @Override
    public void pickup() {

        System.out.println("Picked up " + value + " gold.");
    }

    @Override
    public void drop() {
        System.out.println("Dropped up " + value + " gold.");
    }
}
