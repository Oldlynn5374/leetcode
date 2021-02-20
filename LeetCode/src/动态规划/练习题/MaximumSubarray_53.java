package 动态规划.练习题;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max =dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];

        for (int i = 1; i < nums.length; i++){
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray_53().maxSubArray2(nums));
    }
}
