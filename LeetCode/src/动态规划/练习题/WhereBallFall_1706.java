package 动态规划.练习题;

public class WhereBallFall_1706 {
    public int[] findBall(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        int row = 0;
        while (row < grid.length){
            for (int i = 0; i < dp.length; i++) {
                int column = dp[i];
                if (dp[i] == -1){
                    continue;
                }
                if (grid[row][column] == 1){
                    if (column + 1 >= dp.length){
                        dp[i] = -1;
                    }else if(grid[row][column + 1] == 1){
                        dp[i] += 1;
                    }else {
                        dp[i] = -1;
                    }
                }else if (grid[row][column] == -1){
                    if (column - 1 < 0){
                        dp[i] = -1;
                    }else if (grid[row][column - 1] == -1){
                        dp[i] -= 1;
                    }else {
                        dp[i] = -1;
                    }
                }else {
                    dp[i] = -1;
                }
            }
            row++;
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int[] ball = new WhereBallFall_1706().findBall(grid);
        for (int i : ball){
            System.out.print(i + " ");
        }
    }
}
