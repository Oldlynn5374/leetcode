package bit;

public class ReverseBits_190 {
    public int reverseBits(int n) {
        int ans = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += n & mask;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits_190().reverseBits(43261596));
    }
}
