public class SortArray {
    /*
    input=[0,0,1,2,0,0,1,2,0]
    output=[0,0,0,0,0,1,1,2,2]
     */
    public static int[] sortArray(int[] arr){
        int lastzero = 0, lasttwo = arr.length-1;
        int i = 0;
        while((lastzero < lasttwo) && (i<=lasttwo)){
            while(lastzero < arr.length-1 && arr[lastzero] == 0 ){
                lastzero++;
                i = lastzero;
            }
            while(lasttwo > 0 && arr[lasttwo] == 2 ){
                lasttwo--;
            }
            if(arr[i] == 0){
                swap(arr, lastzero, i);
                lastzero++;
            }
            if(arr[i] == 2){
                swap(arr, lasttwo, i);
                lasttwo--;
                if(arr[i] == 0){
                    swap(arr, lastzero, i);
                    lastzero++;
                }
            }
            i++;
        }
        return arr;
    }

    private static void swap (int[] arr, int i, int position){
        int temp = arr[i];
        arr[i] = arr[position];
        arr[position] = temp;
    }

    public static void main(String[] args) {
        //int[] arr = {0, 0, 1, 2, 0, 2, 2};
        //int [] arr = {2, 0, 1, 2, 0, 2, 0};
        //int [] arr = {1, 1, 1, 2, 0, 2, 0};
        //int [] arr = {1, 1, 1, 1, 1, 1, 1};
        //int [] arr = {2, 2, 2, 2, 2, 2, 2};
        //int [] arr = {0, 0, 0, 0, 0, 0, 0};
        int[] arr = {0, 1, 0, 2, 0, 1, 2};
        arr = sortArray(arr);
        for (int i : arr){
            System.out.println(i);
        }

    }
}
