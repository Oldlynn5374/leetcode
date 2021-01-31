package 动态规划;

public class Martix01_542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        if (matrix.length == 0){
            return dp;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i >= matrix.length || j >= matrix[i].length){
                    continue;
                }

                if ( i != matrix.length-1 && dp[i][j] < dp[i + 1][j] ){
                    dp[i + 1][j] = dp[i][j] + 1;
                }
                if (j != matrix[i].length-1 && dp[i][j] < dp[i][j + 1]  ){
                    dp[i][j + 1] = dp[i][j] + 1;
                }
            }
        }

        for (int i = matrix.length-1; i >= 0; i--){
            for (int j = matrix[i].length-1; j >= 0; j--){
                if (i != 0 && dp[i][j] < dp[i - 1][j]  ){
                    dp[i - 1][j] = dp[i][j] + 1;
                }
                if (j != 0 && dp[i][j] < dp[i][j - 1] ){
                    dp[i][j - 1] = dp[i][j] + 1;
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        Martix01_542 martix01 = new Martix01_542();
        int[][] martix = {{0,1,1,0,0},{0,1,1,0,0},{0,1,0,0,1},{1,1,1,1,0},{1,0,0,1,0}};
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                System.out.print(martix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        int[][] result = martix01.updateMatrix(martix);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
