public class MergeIntervals {
    /*
    You have given a list of intervals. Write a program to merge overlapping intervals.



Sample Input: Given list of intervals: [[1, 3], [2, 6], [8, 10]]
Output: List of intervals after merging: [[1, 6], [8, 10]]



Sample Input:Given list of intervals: [[1, 3], [2, 9], [8, 10]]
Output:List of intervals after merging: [[1, 10]]
     */

    public static int[][] mergeIntervals(int[][] arr){
        int len = arr.length;

        int j=0;
        for(int i=1; i<len; i++){
            if(arr[j][1] >= arr[i][0]){
                arr[j][1] = Math.max(arr[j][1], arr[i][1]);
            }
            else{
                j++;
                arr[j] = arr[i];
            }
        }

        int result[][] = new int[j+1][2];
        for(int i=0; i<=j;i++){
            result[i][0] = arr[i][0];
            result[i][1] = arr[i][1];
        }
        return result;
    }

    public static void main(String[] args){
        //int[][] arr = {{1, 3}, {2, 6}, {8, 10}};
        int[][] arr = {{1, 3}, {2, 9}, {11, 12}};
        int result[][] = mergeIntervals(arr);
        for(int i=0; i<result.length;i++){
            System.out.println(result[i][0]+","+result[i][1]);
        }
    }
}
