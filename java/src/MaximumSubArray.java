import org.jetbrains.annotations.Contract;

public class MaximumSubArray {
    /*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23*/
    @Contract(pure = true)
    public static int maxSubArray(int[] array) {
        int size = array.length;

        int curr = 0,sum, temp=0;
        sum = array[0];//5
        temp = sum;//5
        for(int i=1; i<size;i++){
            curr = array[i];//8
            temp = temp + curr;//16
            if(temp<0){
                temp = curr;//
            }
            if(curr > sum){
                sum = curr;//
            }
            if(temp > sum){
                sum = temp;//16
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int arr[] = new int[]{5,-6,1,7,8};
        //int arr[] = new int[]{-2,1,-3,4,-1,2,1,-7,6};
        System.out.println(maxSubArray(arr));
    }
}
