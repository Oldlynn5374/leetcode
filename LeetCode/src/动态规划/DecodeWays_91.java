package 动态规划;

public class DecodeWays_91 {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.charAt(0) == '0') {
                return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            if (cur == '0') {
                if (prev == '1' || prev == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (prev == '1' || (prev == '2' && cur <= '6')) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }

        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays_91 decodeWays = new DecodeWays_91();
        System.out.println(decodeWays.numDecodings("227"));
    }
}
