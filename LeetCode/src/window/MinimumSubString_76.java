package window;

public class MinimumSubString_76 {

    private int[] need; // t 的字符
    private int[] have; // s 字串的字符

    public String minWindow(String s, String t) {

        need = new int[128];
        have = new int[128];
        String subString;
        String minString = null;

        if (t.length() == 0){
            return null;
        }

        if (t.length() > s.length()){
            return "";
        }

        for (int i = 0; i < t.length(); i++){
             need[t.charAt(i)]++;
        }

        int left = 0;
        int right = t.length() - 1;
        int size = s.length();


        while (right != size){

            have = new int[128];
            subString = s.substring(left,right + 1);
            for (int i = 0; i < subString.length(); i++){
                have[subString.charAt(i)]++;
            }

            if (isCover()){ // 字串包含t
                if (minString == null){
                    minString = subString;
                }else {
                    if (subString.length() < minString.length()){
                        minString = subString;
                    }
                }
                left++;

            }else { // 字串不包含t

                right++;

            }


        }

        if (minString == null){
            minString = "";
        }

        return minString;
    }

    boolean isCover(){

        for (int i = 0; i < 128; i++){
            if (have[i] - need[i] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "A";
        String t = "A";
        System.out.println(new MinimumSubString_76().minWindow(s,t));
    }
}
