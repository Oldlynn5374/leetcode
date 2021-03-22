package 其他.腾讯;

public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return false;
        }
        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int i = 0; i < len; i++) {
            if (dp[i]){
                int length = nums[i];
                for (int j = i + 1; j <= i + length; j++){
                    if (j >= len - 1){
                        return true;
                    }
                    dp[j] = true;
                }
            }
        }
        return dp[len - 1];
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return false;
        }
        if (len == 1){
            return true;
        }
        int min = len - 1;

        for (int i = len - 2; i >= 0; i--){
            int length = nums[i];
            int far = i + length;
            if (far >= min){
                min = i;
                if (min <= 0){
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new JumpGame_55().canJump2(nums));
    }
}
