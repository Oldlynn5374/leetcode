package 动态规划.股票问题;
/*
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/java-dong-tai-gui-hua-qing-xi-jian-ming-ot6n0/
 */
public class BestTimeToBuyAndSellStock4_188 {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        if (days == 0){
            return 0;
        }
        k = Math.min(k, days /2);
        int[][][] dp = new int[days][2][k+1];


        // 第一天，若持有股票，则就是负债第一天的价格
        for (int i = 0; i <=k ; i++) {
            dp[0][1][i] = - prices[0];
        }

        for (int i = 1; i < days; i++){
            for (int j = 0; j <=k; j++){
                // 当前没有股
                if (j < k){
                    // 交易过股票，可能昨天也没有，可能今天卖了
                    dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j+1] + prices[i]);

                }else {
                    // 还没交易过股票
                    dp[i][0][j] = dp[i-1][0][j];
                }

                // 当前持有股,可能昨天也有，可能今天才买
                dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j] - prices[i]);
            }
        }

        int max = 0;
        for (int i = 0; i <= k; i++){
            max = Math.max(max, dp[days-1][0][i]);
        }


        return max;
    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(new BestTimeToBuyAndSellStock4_188().maxProfit(k,prices));
    }
}
