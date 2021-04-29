package bit;

public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        return sum - total;
    }

    public int missingNumber2(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {3, 0 ,1};
        System.out.println(new MissingNumber_268().missingNumber2(nums));
    }
}
