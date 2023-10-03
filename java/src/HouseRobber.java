import java.util.ArrayList;
import java.util.List;

public class HouseRobber {
    static List<Integer> houses = new ArrayList<>();
    public static int rob(int[] nums) {
        int len = nums.length;

        if(len == 1){
            houses.add(0);
            return nums[0];
        }

        if (len == 2){
            houses.add(1);
            return Math.max(nums[0], nums[1]);
        }

        if(len == 3){
            if(nums[1] > nums[0] + nums[2]){
                houses.add(1);
            }
            else{
                houses.add(0);
                houses.add(2);
            }
            return Math.max(nums[1], (nums[0] + nums[2]));
        }

        int dp[] = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for(int i=3; i< len; i++){
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        if(dp[len-1] > dp[len-2]){
            findHouses(dp[len-1], len-1, dp);
        }
        else{
            findHouses(dp[len-2], len-2, dp);
        }
        int max = Math.max(dp[len-1], dp[len-2]);

        return max;
    }

    private static void findHouses(int max, int index, int[] dp){
        if(index <0){
            return;
        }
        if(index == 2){
            if(dp[2]>dp[1]){
                houses.add(2);
            }
            else{
                houses.add(1);
            }
            return;
        }
        if(index == 1 || index == 0){
            if(dp[1]>dp[0]){
                houses.add(1);
            }
            else{
                houses.add(0);
            }
            return;
        }

        houses.add(index);
        if(dp[index-2] > dp[index-3]){
            findHouses(dp[index-2], index-2, dp);
        }
        else{
            findHouses(dp[index-3], index-3, dp);
        }
    }

    public static void main(String[] args){
        int input[] = {1,2,3,7,4};//dp[] = [1, 2, 4, 9, 8]
        int profit = rob(input);
        System.out.println("Profit="+profit);
        for(Integer i : houses){
            System.out.println(i);
        }
    }
}


