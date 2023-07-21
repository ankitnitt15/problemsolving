public class RemoveDuplicatesFromSortedArray {

    /*
    Input = [1,1,2,2,2,3,4,4]
    Output = [1,2,3,4,0,0,0,0]
     */

    public static int[] sortArray(int [] arr){
        int i = 0, j = 0;
        while(j<arr.length){
            if(arr[i] == arr[j]){
                j++;
            }
            else{
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        System.out.println("i="+i);
        for(int k = i+1;k<arr.length; k++ ){
            arr[k] = 0;
        }
        return arr;
    }

    public static void main(String[] args){
        //int arr[] = {1,1,2,2,2,3,4,4};
        //int arr[] = {1,2,2,2,3,4,4,5};
        //int arr[] = {1,2,2,2,3,4,4,5,10,10};
        int arr[] = {1,1,1,1,1,1,2,2,2,3,4,4,5,10,10};
        arr = sortArray(arr);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
