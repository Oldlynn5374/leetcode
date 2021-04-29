package bit;

public class CountingBits_338 {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }
        int[] result = new int[num + 1];
        result[0] = 0;

        int last = 0;
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int mask = 1;
            for (int j = 0; j < 32; j++) {
                int R = mask & last;
                if (R == 0) {
                    res++;
                    break;
                }else {
                    res--;
                }
                mask <<= 1;
            }
            result[i] = res;
            last++;
        }
        return result;
    }

    public int[] countBits2(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;

        for (int i = 1; i <= num ; i++) {
            dp[i] = i % 2 == 0 ? dp[i >> 1] : dp[i - 1] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] bits = new CountingBits_338().countBits2(5);
        for (int bit : bits) {
            System.out.print(bit + " ");
        }
    }
}
