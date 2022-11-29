package observerPattern;

public class GraphObserver implements Observer{
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("Graph Observer");
        int number = numberGenerator.getNumber();

        for (int i = 0; i < number ; i++) {
            System.out.print("*");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
