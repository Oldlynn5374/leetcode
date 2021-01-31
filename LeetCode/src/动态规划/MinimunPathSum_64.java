package 动态规划;

public class MinimunPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (0 == i && 0 == j){
                    continue;
                }else if (0 == i){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                    continue;
                }else if (0 == j){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];


        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MinimunPathSum_64 minimunPathSum = new MinimunPathSum_64();
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(minimunPathSum.minPathSum(grid));
    }
}
