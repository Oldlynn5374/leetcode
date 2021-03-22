package 字符串;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }
        int len = s.length();
        String result = s.charAt(0) + "";
        int max = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        for (int size = 1; size <= len - 1; size++){
            for (int i = 0; i < len - size; i++){
                int j = i + size;

                if (j == i + 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]){
                    if ((j - i + 1) > max){
                        max = j - i + 1;
                        result = s.substring(i,j + 1);
                    }
                }
            }
        }

        return result;
    }

    public boolean isOk(String s){
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2){
            if (s.charAt(p1) != s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "cbbd";
        System.out.println(new LongestPalindromicSubstring_5().longestPalindrome(s1));
    }
}
