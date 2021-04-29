package 练习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {

        int finalLeft = Integer.MIN_VALUE;
        int finalRight = 0;
        int rightValue = 0;

        for (int right = nums.length - 1; right >= 1; right--) {
            int rightVal = nums[right];
            for ( int left = right - 1; left >= 0; left--){
                int leftVal = nums[left];
                if (rightVal > leftVal) {
                    if (left > finalLeft) {
                        finalLeft = left;
                        finalRight = right;
                        rightValue = rightVal;
                    }
                }
            }
        }

        if (finalLeft == Integer.MIN_VALUE) {
            for (int i = 0; i < nums.length >> 1; i++) {
                int left = nums[i];
                int right = nums[nums.length - 1 - i];
                nums[i] = right;
                nums[nums.length - 1 - i] = left;
            }
            return;
        }

        for (int i = finalRight - 1; i >= finalLeft; i--) {
            nums[i + 1] = nums[i];
        }
        nums[finalLeft] = rightValue;
        Arrays.sort(nums, finalLeft + 1, nums.length);

    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        new NextPermutation_31().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
