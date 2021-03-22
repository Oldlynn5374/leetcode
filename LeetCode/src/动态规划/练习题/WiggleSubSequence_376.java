package 动态规划.练习题;

public class WiggleSubSequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int j = 0;
        for (int i = 1; i < nums.length; i++){

            if (i == nums.length - 1){
                if (nums[i] == nums[j]){
                    dp[i] = dp[i-1];
                }else {
                    dp[i] = dp[i-1] + 1;
                }
                break;
            }

            if (nums[i] == nums[i-1]){

            }else {
                j = i - 1;
            }

            if ((nums[i] > nums[j] && nums[i] > nums[i+1]) || (nums[i] < nums[j] && nums[i] < nums[i+1])){
                if (i == nums.length - 2){
                    dp[i] = dp[i-1] + 1;
                    dp[i + 1] = dp[i] + 1;
                    break;
                }
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = dp[i-1];
            }
        }

        return dp[nums.length - 1];
    }

    public int wiggleMaxLength2(int[] nums) {
        boolean isUp = false;

        int result = 2;
        int num1 = nums[0];
        int num2 = nums[1];
        int top = num2;
        if (num1 > num2){
            isUp = true;
        }else {
            isUp = false;
        }

        int pos = 2;
        while (pos < nums.length){
            int num = nums[pos++];

            if (num < top){
                if (isUp){
                    top = num;
                }else {
                    top = num;
                    result++;
                    isUp = !isUp;
                }
            }else if (num > top){
                if (!isUp){
                    top = num;
                }else {
                    top = num;
                    result++;
                    isUp = !isUp;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(new WiggleSubSequence_376().wiggleMaxLength2(nums));
    }
}
