package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class MyArray{
    private Object[] myNumbers;
    private int actSize = 0;

    public MyArray() {
        myNumbers = new Object[10];
    }

    public Object MyArray(int index) {
        if(index<actSize){
            return myNumbers[index];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object element){
        if(myNumbers.length-actSize<5){
             increaseSize();
        }else{
            myNumbers[actSize++]= element;
        }
    }

    public int size(){
        return actSize;
    }

    private void increaseSize(){
        myNumbers = Arrays.copyOf(myNumbers,myNumbers.length*2);
        System.out.println("my new size is " + myNumbers.length);
    }

    public Object get(int i) {
        return myNumbers[i].toString();
    }
}

public class Session03 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(1);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        numbers.add(16);

        Iterator<Integer> ir = numbers.iterator();
        while (ir.hasNext()) {
            Integer value = ir.next();
            if(value<3){
                ir.remove();
            }
        }

        System.out.println(numbers);


    }
}
