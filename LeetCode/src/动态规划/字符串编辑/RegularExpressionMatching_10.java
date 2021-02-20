package 动态规划.字符串编辑;

public class RegularExpressionMatching_10 {
    // 双指针实现
    public boolean isMatch(String s, String p) {
        if (s.equals(p)){
            return true;
        }
        int ps = 0;
        int pp = 0;
        int pp2 = 1;

        char cs;
        char cp ;
        char temp ;

        while (true){
            pp2 = pp + 1;
            if (pp2 >= p.length()){
                pp2 = pp;
            }
            if (ps == s.length()){
                return isOver(p.substring(pp2));
            }

            if (pp == p.length()){
                return false;
            }


            cs = s.charAt(ps);
            cp = p.charAt(pp);
            temp = p.charAt(pp2);

            if (cs == cp || cp == '.'){

                if (cp == '.' && temp == '*'){
                    String n2 = p.substring(pp2 + 1);
                    if (s.length() - n2.length() < 0){
                        return false;
                    }
                    String n1 = s.substring(s.length() - n2.length());
                    return isMatch(n1,n2);
                }

                // 当前位置 match
                ps++;

                if (temp == '*'){
                    // 如果下一位置是 * ,那么 p 的指针先暂时不动

                }else {
                    pp++;
                    if (pp >= p.length()){
                        pp = p.length() ;
                    }
                }
                if (ps == s.length()){
                    return isOver(p.substring(pp));
                }

                continue;

            }else {
                // 当前位置不 match
                if (temp == '*'){
                    pp = pp2 + 1;
                    continue;
                }

                return false;
            }

        }


    }

    public boolean isOver (String str){
        for (int i = 0; i < str.length(); i+=2){
            if (str.charAt(i) != '*'){

                if ( i - 2 >= 0){
                    if (str.charAt(i - 1) == '*' && str.charAt(i - 2) == str.charAt(i)){
                        continue;
                    }
                }

                if (i == str.length() - 1){
                    return false;
                }
                if (str.charAt(i + 1) != '*'){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMatch_dp(String s, String p){

        if (s.length() == 0){
            if (p.length() == 0){
                return true;
            }

            if (p.charAt(p.length()-1) != '*'){
                return false;
            }

            for (int i = 1; i < p.length(); i+=2){
                if (p.charAt(i) != '*'){
                    return false;
                }
            }
            if (p.length() == 1){
                return false;
            }
            return true;
        }

        if (p.length() == 0){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        int count = 0;
        boolean isFound = false;
        // 初始化
        while (true){
            if (s.charAt(0) == p.charAt(count) || p.charAt(count) == '.'){
                for (int k = count-1; k >= 0; k-=2){
                    if (p.charAt(k) == '*'){

                    }else {
                        return false;
                    }
                }
                isFound = true;
                dp[1][count + 1] = true;
                count++;
                while (count < p.length()){
                    if (p.charAt(count) == '*' && dp[1][count]){
                        dp[1][count + 1] = true;
                    }
                    if (count - 2 >= 0 && (p.charAt(count) == p.charAt(count-2) || p.charAt(count) == '.') && p.charAt(count-1) == '*' && (p.charAt(count-2) == '.' || p.charAt(count-2) == s.charAt(0)) && dp[1][count - 1]){
                        dp[1][count + 1] = true;
                    }

                    count++;
                }
            }
            count++;
            if (isFound){
                break;
            }
            if (count >= p.length()){
                return false;
            }
        }

        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= p.length(); j++){
                dp[i][j] = dp[i][j]
                        ||(dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'))
                        || (p.charAt(j-1) == '*' && (dp[i][j-1] || dp[i][j-2]))
                        || (dp[i-1][j-1] && (p.charAt(j-1) == '*' && s.charAt(i-1) == p.charAt(j-2)))
                        || (p.charAt(j-1) == '*' && p.charAt(j-2) == '.' && dp[i-1][j]);
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        RegularExpressionMatching_10 matcher = new RegularExpressionMatching_10();
        System.out.println(matcher.isMatch_dp("bbcacbabbcbaaccabc","b*a*a*.c*bb*b*.*.*"));
    }
}
