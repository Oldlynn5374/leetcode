package 其他.腾讯;

import java.util.Arrays;
import java.util.Stack;

public class Closest3Sum_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < len; i++){
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target){
                    return sum;
                }

                int dif;
                if (sum > target){
                    dif = sum - target;
                    right--;
                }else {
                    dif = target - sum;
                    left++;
                }

                if (dif < min){
                    min = dif;
                    result = sum;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[]nums = {};
        System.out.println(new Closest3Sum_16().threeSumClosest(nums,1));
    }
}
