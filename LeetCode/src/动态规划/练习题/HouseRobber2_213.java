package 动态规划.练习题;

public class HouseRobber2_213 {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        // 不抢最后一间
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length - 1){
                dp[i] = dp[i-1];
            }else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }

        }

        // 不抢第一间
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }

        return Math.max(dp[nums.length-1], dp2[nums.length-1]);
    }

    public static void main(String[] args) {
        int[] a = {4,1,2,7,5,3,1};
        System.out.println(new HouseRobber2_213().rob(a));
    }
}
