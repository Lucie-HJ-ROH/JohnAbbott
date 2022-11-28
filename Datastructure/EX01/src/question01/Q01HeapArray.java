package question01;

import java.util.ArrayList;

public class Q01HeapArray {

    public Integer[] heapArray = null;
    private int cnt = 1;

    public Q01HeapArray(int size) {
        heapArray = new Integer[size+2];
    }

    public boolean insert(Integer data) {
        Integer inserted_index, parent_index;

        if (this.heapArray[1] == null) {
            this.heapArray[1] = data;
            cnt++;
            return true;
        }

        this.heapArray[cnt] = data;
        inserted_index = cnt;

        while (this.move_up(inserted_index)) {
            parent_index = inserted_index / 2 ;
            int temp = heapArray[parent_index];
            heapArray[parent_index] = heapArray[inserted_index];
            heapArray[inserted_index] = temp;
            inserted_index = parent_index;
        }
        cnt++;

        return true;
    }


    public boolean move_up(Integer inserted_index) {
        if (inserted_index <= 1 ) {
            return false;
        }


        Integer parent_index = inserted_index / 2  ;


        if (this.heapArray[inserted_index] > this.heapArray[parent_index]) {
            return true;
        } else {
            return false;
        }
    }


    public Integer remove() {

        if(heapArray[1] ==null)
        {
            return null;
        }
        int lastleft = this.heapArray[heapArray.length - 2];
        int lastright = this.heapArray[heapArray.length - 1];

        if (lastleft > lastright) {
            this.heapArray[cnt-1] = null;
            return lastright;
        }
        this.heapArray[cnt-2] = this.heapArray[cnt-1];
        this.heapArray[cnt-1] = null;


        return lastleft;
    }

    public String showHeap() {
        String result = "";

        for (int i = 1; i < heapArray.length-1; i++) {
                    result = result + " " + heapArray[i];
        }
        if(heapArray[heapArray.length-1]!=null){
            result = result + " " + heapArray[heapArray.length-1];
        }
        return result;
    }

}
