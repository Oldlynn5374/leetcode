package 动态规划.股票问题;

public class BestTimeToBuyAndSellWithCooldown_309 {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0){
            return 0;
        }
        int[][] dp = new int[3][days];

        dp[1][0] = - prices[0];

        for (int i = 1; i < days; i++) {
            dp[0][i] = Math.max(dp[2][i-1], dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] - prices[i]);
            dp[2][i] = dp[1][i-1] + prices[i];

        }

        int max = 0;
        for (int i = 0; i < days; i++) {
            max = Math.max(max, Math.max(dp[0][i], dp[2][i]));
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellWithCooldown_309 stock = new BestTimeToBuyAndSellWithCooldown_309();

        int[] prices = {1,2,3,0,2};
        System.out.println(stock.maxProfit(prices));
    }
}
