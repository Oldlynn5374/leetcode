package 其他.腾讯;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true){
            if (count >= strs[0].length()){
                return sb.toString();
            }
            char ch = strs[0].charAt(count);
            for (int i = 1; i < strs.length; i++) {
                if (count >= strs[i].length() || ch != strs[i].charAt(count)){
                    return sb.toString();
                }
            }
            sb.append(ch);
            count++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(new LongestCommonPrefix_14().longestCommonPrefix(strs));
    }
}
