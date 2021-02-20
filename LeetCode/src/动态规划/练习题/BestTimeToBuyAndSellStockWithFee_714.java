package 动态规划.练习题;

public class BestTimeToBuyAndSellStockWithFee_714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int[][]dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = - prices[0];

        for (int i = 1; i < len; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] + prices[i] - fee);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] - prices[i]);
        }

        return dp[0][len-1];
    }

    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int[]dp = new int[2];
        dp[0] = 0;
        dp[1] = - prices[0];

        for (int i = 1; i < len; i++){
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            //同一天不会同时 买股票 和 卖股票，所以 dp[1] 更新的时候，dp[0] 取max不变，是前一天的值。
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }

        return dp[0];
    }

    public int maxProfit3(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int sell = 0;
        int buy = - prices[0];

        for (int i = 1; i < len; i++){
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }

        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(new BestTimeToBuyAndSellStockWithFee_714().maxProfit(prices,fee));
    }
}
