package question01;

import java.util.ArrayList;
import java.util.Collections;

public class Q1_Heap {
    public ArrayList<Integer> heapArray = null;

    public Q1_Heap(Integer data) {
        heapArray = new ArrayList<Integer>();
        heapArray.add(null);  //index of 0 is null to reduce complexity
        heapArray.add(data);
    }

    public boolean move_up(Integer inserted_idx){
        if(inserted_idx <=1){
            return false;
        }
        Integer parent_idx = inserted_idx/2;
        if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)){
            return true;
        }else{
            return false;
        }
    }

    public boolean insert(Integer data){
        Integer inserted_idx , parents_idx;

        if(heapArray==null){
            heapArray = new ArrayList<Integer>();
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        inserted_idx = this.heapArray.size()-1;

        while(this.move_up(inserted_idx)){
            parents_idx = inserted_idx/2;
            Collections.swap(heapArray, inserted_idx,parents_idx);
            inserted_idx = parents_idx;
        }

        return true;
    }

    public static void main(String[] args) {
        Q1_Heap q1HeapTest = new Q1_Heap(15);
        q1HeapTest.insert(10);
        q1HeapTest.insert(8);
        q1HeapTest.insert(5);
        q1HeapTest.insert(4);

        q1HeapTest.insert(20);

        System.out.println(q1HeapTest.heapArray);
    }


}
