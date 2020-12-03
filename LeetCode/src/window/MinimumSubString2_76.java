package window;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubString2_76 {

    private Map<Character,Integer> need; // t 的字符
    private Map<Character,Integer> have; // s 字串的字符

    public String minWindow(String s, String t) {

        need = new HashMap<>();
        have = new HashMap<>();
        String subString;
        String minString = null;

        if (t.length() == 0){
            return null;
        }

        if (t.length() > s.length()){
            return "";
        }

        for (int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0) + 1);
        }

        int left = 0;
        int right = t.length() - 1;
        int size = s.length();


        while (right != size){

            have = new HashMap<>();
            subString = s.substring(left,right + 1);
            for (int i = 0; i < subString.length(); i++){
                Character c = subString.charAt(i);
                have.put(c,have.getOrDefault(c,0) + 1);
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

        for ( Map.Entry<Character,Integer> entry : need.entrySet() ){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            Integer haveValue = have.get(key);
            if (haveValue == null || haveValue < value){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANCEEE";
        String t = "BNCO";
        System.out.println(new MinimumSubString2_76().minWindow(s,t));
    }
}
