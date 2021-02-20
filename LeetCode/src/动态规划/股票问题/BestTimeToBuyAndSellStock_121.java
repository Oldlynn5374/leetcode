package 动态规划.股票问题;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int[] dp = new int[prices.length];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }

        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new BestTimeToBuyAndSellStock_121().maxProfit(prices));
    }
}
