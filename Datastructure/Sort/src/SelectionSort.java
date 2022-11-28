public class SelectionSort {
    static void sort(int[] arr) {

        int n = arr.length;

        for(int i = 0 ; i < n-1 ; i++) {
            int min = i;
            for(int j = i+1; j < n ; j++) {
                if(arr[j]<arr[min]) {
                    min = j ;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
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
        int arr[] = {64 , 25 , 12, 22 , 11};
        int n  = arr.length;
        sort(arr);

        printarray(arr);
    }
}
