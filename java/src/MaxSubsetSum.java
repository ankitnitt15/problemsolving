public class MaxSubsetSum {
    /*
    Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
    For example, given an array [-2,1,3,-4,5]
    we have the following possible subsets:
Subset      Sum
[-2, 3, 5]   6
[-2, 3]      1
[-2, -4]    -6
[-2, 5]      3
[1, -4]     -3
[1, 5]       6
[3, 5]       8
Our maximum subset sum is 8
     */
    public static int maxSubsetSum(int[] array){
        int result;
        int size = array.length;
        if(size == 1) return array[0];
        if (size == 2){
            return (array[0] > array[1] ? array[0] : array[1]);
        }

        int sum[] = new int[size];
        sum[0] = array[0];
        result = (array[0] > array[1] ? array[0] : array[1]);
        sum[1] = result;
        int temp ; int max;
        for(int i = 2; i<size; i++){
            temp= array[i] + sum[i-2];
            max = array[i];
            if(temp > array[i]) {
                max = temp;
            }
            if(result> max) {
                max = result;
            }
            sum[i] = max;
            if(sum[i] > result) {
                result = sum[i];
            }
        }
        return result;
    }
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);
        if(len == 3)
            return Math.max(nums[1], (nums[0] + nums[2]));
        int dp[] = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        for(int i=3; i< len; i++){
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        return Math.max(dp[len-1], dp[len-2]);
    }

    public static void main (String[] args){
        //int arr[] = {-2,1,3,-4,5};
        //int arr[] = {3,7,4,6,5};
        //int arr[] = {2,1,5,8,4};
        //int arr[] = {-2,-1,-5,-8,-4};
        //int arr[] = {-2,-1,-5,-8,4};
        //int arr[] = {-2,1,5,-8,4};
        //int arr[] = {3,2,-7,8};
        int arr[] = {6,5,10,13,1,8,2,9};//3,5,-4,13,10
        int result = maxSubsetSum(arr);
        int res = rob(arr);
        System.out.println(result+"###"+res);
        MaxSubsetSum a = new child();
    }
}

class child extends MaxSubsetSum{
    public child(){
        super();
    }

    public void print(){

    }

    public static int maxSubsetSum(int[] array){
        return 0;
    }
}