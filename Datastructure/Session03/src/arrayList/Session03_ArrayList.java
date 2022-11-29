package arrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class Session03_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(0);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        numbers.add(16);

        Iterator<Integer> ir = numbers.iterator();
        while (ir.hasNext()) {
            Integer value = ir.next();
            if (value < 3) {
                ir.remove();
            }
        }

        System.out.println(numbers);
    }
}
