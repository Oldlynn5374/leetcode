package 其他.腾讯;

public class ProductofArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        if (len == 0){
            return dp;
        }

        int sum = 1;
        for (int i = 1; i < len; i++) {
            sum *= nums[i];
        }
        dp[0] = sum;

        for (int i = 1; i < len; i++) {
            int pre = nums[i - 1];
            int cur = nums[i];
            if (cur == 0){
                sum = 1;
                for (int j = 0; j < len; j++) {
                    if (i == j) continue;
                    sum *= nums[j];
                }
                dp[i] = sum;
            }else {
                dp[i] = dp[i - 1] / cur * pre;
            }
        }

        return dp;
    }

    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int temp = 1;
        for (int i = 0; i < len; i++){
            res[i] = temp;  // res 存的是 i 左边的乘积
            temp *= nums[i];
        }

        temp = 1;
        for (int i = len - 1; i >= 0; i--){
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] results = new ProductofArrayExceptSelf_238().productExceptSelf2(nums);
        for (int i : results){
            System.out.print(i + " ");
        }
    }
}
