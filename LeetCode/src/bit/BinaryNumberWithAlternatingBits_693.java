package bit;

public class BinaryNumberWithAlternatingBits_693 {
    public boolean hasAlternatingBits(int n) {

        int bitCount = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            int bit = n & mask;
            if (bit == 0) {
                bitCount++;
            }else {
                break;
            }
        }

        int mask1 = 1431655765 << bitCount;
        int mask2 = 715827882 << bitCount;
        n <<= bitCount;

        int r1 = mask1 ^ n;
        int r2 = mask2 ^ n;


        return r1 == 0 || r2 == 0 ? true : false;
    }

    public static void main(String[] args) {

        System.out.println(new BinaryNumberWithAlternatingBits_693().hasAlternatingBits(2));

/*        int res = 0;
        int mask = 1;
        for (int i = 0; i < 16; i++) {
            res |= mask;
            mask <<= 2;
        }

        System.out.println(res);
        System.out.println(Integer.toBinaryString(res));

        int res2 = 0;
        int mask2 = 2;
        for (int i = 0; i < 15; i++) {
            res2 |= mask2;
            mask2 <<= 2;
        }

        System.out.println(res2);
        System.out.println(Integer.toBinaryString(res2));*/
    }
}
