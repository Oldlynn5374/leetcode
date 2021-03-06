package 动态规划.字符串编辑;

public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length() ; i++) {

            for (int j = 0; j <= word2.length() ; j++) {
                if (i == 0){
                    dp[i][j] = j;
                }else if (j == 0){
                    dp[i][j] = i;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1] +((word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1),Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }

            }

        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance_72 editDistance = new EditDistance_72();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(editDistance.minDistance(word1, word2));
    }
}
