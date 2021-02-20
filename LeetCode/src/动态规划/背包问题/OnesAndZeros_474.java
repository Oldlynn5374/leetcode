package 动态规划.背包问题;

public class OnesAndZeros_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        if (length == 0){
            return 0;
        }
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i <= length; i++) {
            String str = strs[i-1];
            int[] count = counter(str);
            int count0 = count[0];
            int count1 = count[1];
            for (int j = 0; j <= m ; j++) {
                for (int k = 0; k <= n ; k++) {
                    if (j - count0 >= 0 && k - count1 >= 0){
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-count0][k-count1] + 1);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }

                }
            }
        }

        return dp[length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for (String str : strs){
            int[] count = counter(str);
            int count0 = count[0];
            int count1 = count[1];
            for (int i = m; i >=count0; i--){
                for (int j = n; j >= count1; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-count0][j-count1] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeros_474 onesAndZeros = new OnesAndZeros_474();
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        System.out.println(onesAndZeros.findMaxForm2(strs,m,n));
    }
    public int[] counter(String str){
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0'){
                count0++;
            }else {
                count1++;
            }
        }

        return new int[]{count0,count1};
    }


}
