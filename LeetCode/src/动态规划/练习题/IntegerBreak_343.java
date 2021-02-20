package 动态规划.练习题;

public class IntegerBreak_343 {
    public int integerBreak(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(dp[i], Math.max( (i-j) * j, dp[i - j] * j ));
            }
        }

        return dp[n];
    }

    public int integerBreak2(int n) {

        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 3;
        }
        if (n == 4){
            return 4;
        }

        return 3 * integerBreak2(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak_343().integerBreak(1));
    }
}
