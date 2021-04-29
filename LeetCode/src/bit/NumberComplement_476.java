package bit;

public class NumberComplement_476 {
    public int findComplement(int num) {
        int bitCount = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            int m = mask & num;
            if (m == 0) {
                bitCount++;
            }else {
                break;
            }
        }

        int res = 0;
        for (int i = 0; i < 32 - bitCount; i++) {
            int mask = 1 << i;
            int m = mask & num;
            if (m == 0) {
                res += mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int result = new NumberComplement_476().findComplement(2);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }
}
