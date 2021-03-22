package 动态规划.练习题;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubmatricesWithAllOnes_1504 {
    public int numSubmat(int[][] mat) {
            int rl = mat.length;
            int cl = mat[0].length;
            int[][] dp = new int[rl + 1][cl + 1];

            for (int i = 1; i <= rl; i++){
                dp[i][1] = dp[i - 1][1] + extra(mat, i, 1);
            }
            for (int j = 1; j <= cl; j++){
                dp[1][j] = dp[1][j - 1] + extra(mat, 1, j);
            }

            for (int i = 2; i <= rl; i++){
                for (int j = 2; j <= cl; j++){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + extra(mat, i, j);
                }
            }
            return dp[rl][cl];
        }

        public int extra(int[][] mat, int row, int column){
            row--;
            column--;
            if (mat[row][column] == 0){
                return 0;
            }

            int sum = 1;
            int width = 1; // 最小底长
            int heigh = 1; // 高
            for (int x = column - 1; x >= 0; x--){
                if (mat[row][x] == 0){
                    break;
                }
                sum++;
                width++;
            }

        for (int y = row - 1; y >= 0; y--){
            if (mat[y][column] == 0){
                break;
            }
            //sum++;
            heigh++;
        }

        // 自底向上累加矩形个数
        for (int i = 1; i < heigh; i++){
            row--;
            int y = column;
            for (int j = 0; j < width; j++){
                if (mat[row][y--] == 1){
                    sum++;
                }else {
                    width = j;
                    break;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {};

        System.out.println(new CountSubmatricesWithAllOnes_1504().numSubmat(mat));
}
}
