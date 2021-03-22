package 动态规划.练习题;

import java.util.Arrays;
import java.util.Map;

public class FillingShelves_1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int dp[] = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= books.length; i++){
            int width = books[i - 1][0];
            int h = books[i-1][1];
            dp[i] = dp[i - 1] + h;

            // 把上一层的拉下来
            for (int j = i - 1; j >= 1; j--){
                int lastWidth = books[j - 1][0];
                int lastHeigh = books[j - 1][1];
                if ((lastWidth + width) > shelf_width){
                    break;
                }else {
                    int th = Math.max(h, lastHeigh);
                    int nd = (dp[j - 1] + th);
                    if (dp[i] >= nd){
                        dp[i] = nd;
                        h = th;
                        width = width + lastWidth;
                    }else {
                        break;
                    }
                }
            }

        }

        return dp[books.length];
    }

    public static void main(String[] args) {
        int[][] books = {{1,3},{2,4},{3,2}};
        int width = 6;
        System.out.println(new FillingShelves_1105().minHeightShelves(books, width));
    }
}
