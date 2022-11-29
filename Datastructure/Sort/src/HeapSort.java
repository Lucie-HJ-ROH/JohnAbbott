public class HeapSort {

    public static void heapSort(int[] arr) {
        heapSort(arr,arr.length);
    }

    private static void heapSort(int[] arr, int size) {

        if(size<2){
            return;
        }
        /*
            left child node = index * 2 + 1
            right child node = index * 2 + 2
            parent node = (index -1) / 2
         */

        //the parent index of last node
        int parentIdx = getParentIdx(size-1);

        //max heap
        for (int i = parentIdx; i>=0; i--){
            heapify(arr,i,size-1);
        }

        for (int i = size-1; i>0; i--){
            swap(arr,0,i);// put the max digit into last array.
            heapify(arr,0,i-1);// make max hea[

        }
    }

    //parent index
    private static int getParentIdx(int child) {
        return (child - 1) / 2;
    }

    //for swap 2 indexes
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }





    private static void heapify(int[] arr, int parentIdx, int lastIdx) {
        int leftChildIdx = 2 * parentIdx + 1;
        int rightChildIdx = 2 * parentIdx + 2;
        int largestIdx = parentIdx;

        /*
            1. compare left child
            if left child is bigger than largestIdx && left child isn't bigger that last index.
            change largestIdx to left child
         */

        if (leftChildIdx <= lastIdx && arr[largestIdx] < arr[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }

        /*
            2. compare right child
            if right child is bigger than largestIdx && right child isn't bigger that last index.
            change largestIdx to right child
         */

        if (rightChildIdx <= lastIdx && arr[largestIdx] < arr[rightChildIdx]) {
            largestIdx = rightChildIdx;
        }
         /*
             3. swap parent and child position
            largestIdx isn't equal to parentIdx ,
            change parent to child
         */
        if(parentIdx !=largestIdx){
            swap(arr,largestIdx,parentIdx);
            heapify(arr,largestIdx,lastIdx);
        }

    }

    public static void main(String[] args) {
        int[] arr = {3,7,5,4,2,8};

        System.out.print("Array Before Heap Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + ", ");
        }


        System.out.println();

        heapSort(arr);

        System.out.print("Array After Max Heap Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + ", ");
        }

        System.out.println();


    }
}
