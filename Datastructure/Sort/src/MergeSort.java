public class MergeSort {


    public static void main(String[] args) {
        int arr[] = {12, 75, 99, 1, 0};

        System.out.print("Array before merge sort : ");
        printArray(arr);

        System.out.println();

        mergeSort(arr, 0, arr.length-1);

        System.out.print("Array before merge sort : ");
        printArray(arr);
        System.out.println();

    }


     static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r - 1) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);

        }
    }

     static void merge(int[] arr, int l, int m, int r) {
        int s1 = m - l + 1;
        int s2 = r - m;

        int L[] = new int[s1];
        int R[] = new int[s2];



        for (int i = 0; i < s1; i++) {
            L[i] = arr[l +i];
        }

        for (int i = 0; i <s2; i++) {
            R[i] = arr[m+1+i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < s1 && j < s2) {
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<s1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < s2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void printArray(int[] arr) {

        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
