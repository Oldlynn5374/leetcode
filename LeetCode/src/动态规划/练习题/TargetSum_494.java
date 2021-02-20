package 动态规划.练习题;

import java.util.Arrays;

public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        int target = ( S + sum ) >> 1;
        if ((sum + S) % 2 != 0 || S > sum){
            return 0;
        }

        int[][] dp = new int[ nums.length + 1][target + 1];
        dp[0][0] = 1;
        System.out.println(nums.length + "----------" + target);

        for (int i = 1; i <= nums.length; i++){
            for (int j = 0; j <= target; j++){
                if (j < nums[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j-nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }

    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        int target = ( sum + S ) >> 1;
        if ((sum + S) % 2 != 0 || S > sum){
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums){
            for (int i = target; i >= 0; i--){
                if (i < num){

                }else {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(new TargetSum_494().findTargetSumWays2(nums,S));
    }
}
