package 动态规划;

public class HouseRobber_198 {
    public Integer max = Integer.MIN_VALUE;
    public int rob(int[] nums) {
/*        dfs(nums,0,0);
        dfs(nums,0,1);*/
/*        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);*/
        int p1 = nums[0];
        int p2 = Math.max(p1,nums[1]);
        int max = 0;


        for (int i = 2; i < nums.length; i++) {
            // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(p2, p1 + nums[i]);
            p1 = p2;
            p2 = max;
        }

        // return dp[nums.length - 1];
        return max;
    }

    public void dfs(int[]nums, int count, int pos){
        if (pos >= nums.length){
            if (count > max){
                max = count;
            }
            System.out.println(count);
            return;
        }

        count += nums[pos];


        dfs(nums,count,pos + 2);
        dfs(nums,count,pos + 3);

    }

    public static void main(String[] args) {
        HouseRobber_198 houseRobber = new HouseRobber_198();
        int[] nums = {2,7,9,3,1}   ;
        int max = houseRobber.rob(nums);
        System.out.println(max);
    }
}
