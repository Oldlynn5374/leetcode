package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncrSub_300 {
    public int lengthOfLIS(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }


        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] tail = new int[nums.length];
        int res = 0;
        tail[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            int num = nums[i];
            if (num > tail[res]){
                res++;
                tail[res] = num;
            }else {
                int pos = lower_bound(tail,0,res + 1,num);
                tail[pos] = num;
            }
        }


        return res + 1;
    }


    public int lower_bound(int[] arr, int begin, int end, int tar) {
        while(begin < end) {
            int mid = begin + (end - begin) / 2;
            // 当 mid 的元素小于 tar 时
            if(arr[mid] < tar)
                // begin 为 mid + 1, arr[begin] 的值会小于或等于 tar
                begin = mid + 1;
                // 当 mid 的元素大于等于 tar 时
            else if(arr[mid] >= tar)
                end = mid;
        }
        return begin;
    }



    public static void main(String[] args) {
        LongestIncrSub_300 longestIncrSub = new LongestIncrSub_300();
        int[] a = {2,0,1,1,3};
        System.out.println(longestIncrSub.lengthOfLIS2(a));
/*        int i = longestIncrSub.lower_bound(a, 0, a.length, 3);
        System.out.println(i);*/
    }
}
