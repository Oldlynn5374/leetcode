package 动态规划.字符串编辑;

public class TwoKeysKeyboard_650 {
    public int minSteps(int n) {
        if (n <= 0){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <=n; i++){
            int x = findDivision(i);
            dp[i] = dp[x] + 1 + (i / x - 1);
        }

        return dp[n];
    }

    public int minSteps2(int n) {
        if (n == 1){
            return 0;
        }
        int x =findDivision(n);
        return minSteps2(x) + 1 + (n / x - 1);
    }



    public int findDivision(int n){
        for (int i = n - 1; i >= 1; i--){
            if (n % i == 0){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard_650 twoKeysKeyboard = new TwoKeysKeyboard_650();
        System.out.println(twoKeysKeyboard.minSteps2(12));
    }
}
