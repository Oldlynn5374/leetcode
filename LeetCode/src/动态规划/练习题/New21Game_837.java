package 动态规划.练习题;

public class New21Game_837 {
    public double new21Game(int N, int K, int W) {
        double dp[] = new double[W + K];

        double s = 0;
        for (int i = K; i <= W + K - 1; i++){
            if (i <= N){
                dp[i] = 1;
            }else {
                dp[i] = 0;
            }
            s += dp[i];
        }

        for (int i = K - 1; i >=0; i--){

            dp[i] = s;
            dp[i] /= W;
            s = s + dp[i] - dp[i + W];
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int N = 21;
        int K = 17;
        int W = 10;
        System.out.println(new New21Game_837().new21Game(N,K,W));
    }
}
