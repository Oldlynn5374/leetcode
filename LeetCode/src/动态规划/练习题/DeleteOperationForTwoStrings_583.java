package 动态规划.练习题;

public class DeleteOperationForTwoStrings_583 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;

        for (int i = 0; i <=n; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                dp[i][j] = Math.min( dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)? 0 : 2) ,
                                     Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "";
        String word2 = "";
        System.out.println(new DeleteOperationForTwoStrings_583().minDistance(word1,word2));
    }
}
