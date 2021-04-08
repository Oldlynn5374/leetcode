package test;

import java.util.Arrays;
import java.util.Scanner;

public class Solution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        // 背包问题
        int min = Integer.MAX_VALUE;
        for (int a = 0; a < T; a++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] w = new int[n];
            int maxWeight = 0;
            for (int b = 0; b < n; b++) {
                w[b] = in.nextInt();
                if (w[b] < 0) {
                    throw new IllegalArgumentException("重量不能小于0");
                }
                maxWeight += w[b];
            }

            for (int weight = m; weight <= maxWeight; weight++) {
                int[][] dp= new int[n + 1][weight + 1];
                for (int[] d : dp) {
                    Arrays.fill(d, Integer.MAX_VALUE - 1000);
                    d[0] = 0;
                }
                dp[0][0] = Integer.MAX_VALUE - 1000;
                for (int i = 0; i < weight; i++) {
                    if (w[0] == i) {
                        dp[1][i] = 1;
                        break;
                    }
                }
                for (int i = 2; i <= n; i++) {
                    for (int j = 1; j <= weight; j++) {
                        if (j - w[i - 1] < 0){
                            dp[i][j] = dp[i - 1][j];
                        }else {
                            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + 1);
                        }
                    }
                }
                if (dp[n][weight] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[n][weight]);
                }
            }
        }
        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        }else {
            System.out.println(-1);
        }

    }
}
