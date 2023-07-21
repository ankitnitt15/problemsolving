public class QuickSort {

    public static void sort(int[] arr, int left, int right){
        int n = right - left + 1;
        if (n <= 1){
            return;
        }
        int i = left;
        int j = right;
        int pivot = (right+left)/2;
        int temp;
        while(i<=j){
            while(arr[i] < arr[pivot]){
                i++;
            }
            while(arr[j] > arr[pivot]){
                j--;
            }
            if(i<=j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        sort(arr, left, j);
        sort(arr, i, right);
    }

    public static void main(String[] args){
        int arr[] = new int[]{12,5,3,10,4,11,8};
        int size = arr.length;
        sort(arr, 0, size-1);
        for(int i=0; i<size; i++){
            System.out.println(arr[i]);
        }
    }
}
