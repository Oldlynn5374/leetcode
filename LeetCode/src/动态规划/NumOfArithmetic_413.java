package 动态规划;

public class NumOfArithmetic_413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2){
            return 0;
        }
        int count = 0;
        int[] dp = new int[A.length];
        dp[0] = dp[1] = 0;

        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1] + 1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            count += dp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        NumOfArithmetic_413 numOfArithmetic = new NumOfArithmetic_413();
        int[] A = {1, 2, 3, 4};
        System.out.println(numOfArithmetic.numberOfArithmeticSlices(A));
    }
}
