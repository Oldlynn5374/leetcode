package 动态规划;

public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int max = 1;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {

                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                }

                max = Math.max(max,dp[i][j]);

            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        MaximalSquare_221 maximalSquare = new MaximalSquare_221();
        char[][] martix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare.maximalSquare(martix));
    }


}
