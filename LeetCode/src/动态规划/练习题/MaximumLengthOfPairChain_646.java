package 动态规划.练习题;

import java.util.Arrays;

public class MaximumLengthOfPairChain_646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0){
            return 0;
        }
        Arrays.sort(pairs,(a,b)-> a[0]-b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);

        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++){
                if (pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[dp.length-1];
    }

    public int findLongestChain2(int[][] pairs) {
        if (pairs.length == 0){
            return 0;
        }
        Arrays.sort(pairs,(a,b)-> a[1]-b[1]);
        int res = 1;
        int temp = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > temp){
                res++;
                temp = pairs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] pairs = {{-7,-1},{2,3},{4,5},{3,6},{7,9},{7,9},{0,10},{3,10}};
        System.out.println(new MaximumLengthOfPairChain_646().findLongestChain2(pairs));
    }
}
