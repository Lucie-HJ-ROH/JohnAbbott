public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3,60,35,2,45,320,5};

        System.out.print("Array Before Bubble Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + ", ");
        }


        System.out.println();

        bubbleSort(arr);

        System.out.print("Array After Bubble Sort : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + ", ");
        }
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j <arr.length; j++) {
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

}
