package 动态规划.练习题;

import java.util.*;

public class CheapestFlightsWithinKStops_787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int flight = flights.length;
        int[][] dp = new int[K + 1][n];
        for (int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= K; i++) {
            dp[i][src] = 0;
        }

        for (int[] info : flights){
            int from = info[0];
            int to = info[1];
            int fee = info[2];
            if (from == src){
                dp[0][to] = fee;
            }
        }

        for (int k = 1; k <= K; k++){
            for (int[] info : flights){
                int from = info[0];
                int to = info[1];
                int fee = info[2];

                if (dp[k - 1][from] != Integer.MAX_VALUE){
                    dp[k][to] = Math.min(dp[k][to], dp[k - 1][from] + fee);
                }

                dp[k][to] = Math.min(dp[k][to], dp[k - 1][to]);
            }
        }

        if (dp[K][dst] == Integer.MAX_VALUE){
            return -1;
        }

        return dp[K][dst];

    }

    public static void main(String[] args) {
        int[][] flights = {{1,0,5}};
        int n = 2;
        int src = 0;
        int dst = 1;
        int K = 1;
        System.out.println(new CheapestFlightsWithinKStops_787().findCheapestPrice(n,flights,src,dst,K));

    }
}
