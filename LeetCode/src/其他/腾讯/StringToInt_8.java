package 其他.腾讯;

public class StringToInt_8 {
    public int myAtoi(String s) {
        int len = s.length();
        // 除前面的空格
        int pos = 0;
        while (pos < len && s.charAt(pos) == ' '){
            pos++;
        }
        if (pos == len){
            return 0;
        }

        int res = 0;
        boolean isNegative = false;
        if (s.charAt(pos) == '+'){
            isNegative = false;
            pos++;
        }else if (s.charAt(pos) == '-'){
            isNegative = true;
            pos++;
        }

        while (pos < len){
            char ch = s.charAt(pos);
            if (ch < '0' || ch > '9'){
                break;
            }

            if(!isNegative && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10)) ){
                return Integer.MAX_VALUE;
            }

            if(isNegative && (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && -(ch - '0') < (Integer.MIN_VALUE % 10)) )){
                return Integer.MIN_VALUE;
            }

            res = res * 10 + (ch - '0');
            pos++;
        }

        if (isNegative){
            res = -res;
        }

        return res;

    }

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int temp = x;

        int reverse = 0;
        while (x > 0){
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        if (reverse == temp){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "121";
        System.out.println(new StringToInt_8().isPalindrome(121));
    }
}
