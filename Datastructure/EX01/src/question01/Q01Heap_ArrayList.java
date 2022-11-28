package question01;

import java.util.ArrayList;

public class Q01Heap_ArrayList {

    public ArrayList<Integer> heapArray = null;

    public Q01Heap_ArrayList(Integer data) {
        heapArray = new ArrayList<Integer>();

        heapArray.add(null); // For the convenience of calculation, the 0th list is made null and the Index is used from 1.
        heapArray.add(data);
    }

    public boolean insert(Integer data){
        Integer inserted_index, parent_index;

        if(heapArray==null) {
            heapArray = new ArrayList<Integer>();

            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        this.heapArray.add(data);
        inserted_index =this.heapArray.size() - 1;

        while(this.move_up(inserted_index)){
            parent_index = inserted_index/2;
            int temp = heapArray.get(parent_index);
            heapArray.set(parent_index, heapArray.get(inserted_index));
            heapArray.set(inserted_index, temp);
            inserted_index = parent_index;
        }

        return true;
    }

    public boolean move_up(Integer inserted_index){
        if(inserted_index<=1){
            return false;
        }
        Integer parent_index = inserted_index/2;
        if(this.heapArray.get(inserted_index)> this.heapArray.get(parent_index)){
            return true;
        }else{
            return false;
        }
    }


    public Integer remove() {
        int lastleft = this.heapArray.get(this.heapArray.size()-2);
        int lastright = this.heapArray.get(this.heapArray.size()-1);

        if(lastleft>lastright){
            this.heapArray.remove(this.heapArray.size()-1);
            return lastright;
        }


        this.heapArray.remove(this.heapArray.size()-2);
        return lastleft;
    }
}
