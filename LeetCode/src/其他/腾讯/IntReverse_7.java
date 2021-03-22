package 其他.腾讯;

public class IntReverse_7 {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = -x;
        }

        while (x > 0){
            sb.append(x % 10);
            x /= 10;
        }

        int result = Integer.valueOf(sb.toString());

        if (isNegative){
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(new IntReverse_7().reverse(x));
    }
}
