package bit;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }

        return ans;
    }

    public boolean is(int n ) {
        int b1 = n & (n - 1);
        int b2 = n & 1431655765;
        return n > 0 && b1 == 0 && b2 !=0;
    }
}
