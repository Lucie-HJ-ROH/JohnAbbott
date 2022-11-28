public class QuickSort {


    static void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int part(int[] arr , int low , int high) {

        int pivot = arr[high];
        int  i = (low - 1);
        for(int j = low ; j <= high-1; j++) {

            if(arr[j]< pivot) {
                i++;
                swap(arr, i , j);
            }
        }
        swap(arr, i+1 , high);
        return (i+1);
    }

    static void qs(int[]arr ,  int low , int high) {
        if(low  < high) {
            int m = part(arr, low, high);

            qs(arr , low , m-1);
            qs(arr , m+1 , high);
        }
    }


    static void printarray(int arry[]) {
        int s = arry.length;
        for(int i = 0 ; i < s ; i++) {
            System.out.print(arry[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int arr[] = {12 , 75 , 99, 1 , 0};
        int n  = arr.length;
        qs(arr,0,n-1);

        printarray(arr);

    }
}
