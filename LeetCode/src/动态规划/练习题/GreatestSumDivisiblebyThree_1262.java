package 动态规划.练习题;

import java.util.*;

public class GreatestSumDivisiblebyThree_1262 {
    public int maxSumDivThree(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][3];

        for (int i = 1; i <= len; i++) {
            int value = nums[i - 1];
            int remain = value % 3;

            if (remain == 0){
                dp[i][0] = dp[i - 1][0] + value;
                dp[i][1] = dp[i - 1][1] == 0 ?0 : dp[i - 1][1] + value;
                dp[i][2] = dp[i - 1][2] == 0 ?0 : dp[i - 1][2] + value;
            }else if (remain == 1){
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] == 0 ?-1 : dp[i - 1][2] + value);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + value);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] == 0 ?-1 : dp[i - 1][1] + value);
            }else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] == 0 ?-1 : dp[i - 1][1] + value);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] == 0 ?-1 : dp[i - 1][2] + value);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + value);
            }
        }
        return dp[len][0];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        System.out.println(new GreatestSumDivisiblebyThree_1262().maxSumDivThree(nums));
    }
}
