package 动态规划.背包问题;


public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i - 1]; j <= target; j++) {
                dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
        }

        return dp[nums.length][target];
    }
    public boolean canPartition2(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;


        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j-nums[i-1]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum_416 partitionEqualSubsetSum = new PartitionEqualSubsetSum_416();
        int[] a = {1,2,3,2};
        System.out.println(partitionEqualSubsetSum.canPartition2(a));
    }
}
