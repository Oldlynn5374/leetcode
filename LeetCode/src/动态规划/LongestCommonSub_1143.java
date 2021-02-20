package 动态规划;

public class LongestCommonSub_1143 {
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.length() == 0 || text2.length() == 0){
            return 0;
        }

        int[][] dp = new int[text1.length()][text2.length()];
        if (text1.charAt(0) == text2.charAt(0)){
            dp[0][0] = 1;
        }else {
            dp[0][0] = 0;
        }

        for (int i = 1; i < text2.length(); i++) {
            if (text1.charAt(0) == text2.charAt(i)){
                dp[0][i] = 1;
            }else {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i < text1.length(); i++) {
            if (text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                int bigger = Math.max(dp[i][j-1] , dp[i-1][j]);
                int value = dp[i-1][j-1] + 1;
                if (text1.charAt(i) == text2.charAt(j)){

                    dp[i][j] = value;

                }else {
                    dp[i][j] = bigger;
                }
            }

        }


        return dp[text1.length() - 1][text2.length() - 1];
    }



    public static void main(String[] args) {
        LongestCommonSub_1143 longestCommonSub = new LongestCommonSub_1143();
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        System.out.println(longestCommonSub.longestCommonSubsequence(text1, text2));
    }
}
