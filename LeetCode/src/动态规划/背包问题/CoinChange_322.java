package 动态规划.背包问题;

import java.util.Arrays;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= amount; i++ ){
            dp[0][i] = amount + 2;
        }

        for (int i = 1; i <= coins.length; i++){
            int value = coins[i-1];
            for (int j = 1; j <= amount; j++){
                if (j >= value){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-value] + 1);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount] == amount + 2? -1: dp[coins.length][amount] ;
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 2);
        dp[0] = 0;

        for (int j = 1; j <= amount; j++){
            for (int value : coins){
                if (value > j){
                    // 当前硬币面值比 j 还大，所以不能用当前的硬币，略过
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j-value] + 1);
            }
        }

        return dp[amount] == amount + 2 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange_322 coinChange = new CoinChange_322();
        int[] coins = {2};
        int amount = 3;

        System.out.println(coinChange.coinChange2(coins,amount));
    }
}
