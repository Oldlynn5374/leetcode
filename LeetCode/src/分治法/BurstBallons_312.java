package 分治法;

import java.util.*;

public class BurstBallons_312 {

    public int maxCoins(int[] nums) {
        int[] nums2 = new int[nums.length + 2];
        int len = nums2.length;
        nums2[0] = 1;
        nums2[len-1] = 1;
        for (int i = 1; i < len - 1; i++){
            nums2[i] = nums[i-1];
        }

        int[][] dp = new int[len][len];

        for (int size = 2; size <= len; size++){
            for (int i = 0; i < len - size; i++){
                int j = i + size;

                int max = 0;
                for (int k = i + 1; k < j; k++){
                    int left = dp[i][k];
                    int right = dp[k][j];
                    int value = left + nums2[i] * nums2[k] * nums2[j] + right;
                    if (value > max){
                        max = value;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][len-1];
    }



    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(new BurstBallons_312().maxCoins(nums));
    }

}
