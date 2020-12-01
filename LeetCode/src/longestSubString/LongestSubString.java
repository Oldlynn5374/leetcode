package longestSubString;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {

        int length = 0;
        String sub;
        int begin = 0;
        int end = 1;
        Map <Character,Character> map = new HashMap<>();
        int counter = 0;

        while(true){
            if(end > s.length()){
                break;
            }
            sub = s.substring(begin,end);
            Character c = s.charAt(counter++);

            if(map.containsKey(c)){//重复
                begin++;
                end++;
                //map.remove(c);
                continue;
            }else {//不重复
                map.put(c,c);
                length++;
                end++;
            }

        }


        return length;
    }

    boolean isDuplicated(String str){

        Map <Character,Character> map = new HashMap<>();
        Character c = null;
        for(int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,c);
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        String sub = "pwwkew";
        System.out.println(longestSubString.lengthOfLongestSubstring(sub));
    }
}
