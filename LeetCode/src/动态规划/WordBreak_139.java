package 动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Set<String> words2 = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        boolean isExist = false;
        boolean isOver = false;
        boolean isFound = false;
        boolean isFound2 = false;

        for (p1 = 0; p1 < s.length(); p1++) {
            isFound2 = false;
            for (p2 = p1; p2 <= s.length(); p2++){
                String value = s.substring(p1,p2);

                if (words.contains(value)){
                    isFound = true;
                    words.remove(value);
                    words2.add(value);
                }else if (words2.contains(value)){
                    isFound2 = true;
                }

                if (isFound){
                    // 存在该单词
                    if (p2 == s.length()){
                        isExist = true;
                    }

                    p1 = p2 - 1;
                    isFound = false;
                    break;
                }

                if (p2 == s.length()){
                    if (isFound2){
                        isExist = true;
                        break;
                    }
                    isOver = true;
                }
            }

            if (isOver){
                break;
            }
        }

        return isExist;
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        int size = s.length();
        boolean[]dp = new boolean[size + 1];
        dp[0] = true;
        Set<String> word = new HashSet<>(wordDict);

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j <= i ; j++) {
                String value = s.substring(j,i);
                if (word.contains(value) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[size];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
/*        wordDict.add("cc");
        wordDict.add("bb");
        wordDict.add("aa");
        wordDict.add("bc");
        wordDict.add("ac");
        wordDict.add("ca");
        wordDict.add("ba");*/
        wordDict.add("aa");
        wordDict.add("aaaa");
        wordDict.add("a");



        WordBreak_139 wordBreak = new WordBreak_139();
        boolean b = wordBreak.wordBreak2(s, wordDict);
        System.out.println(b);
    }
}
