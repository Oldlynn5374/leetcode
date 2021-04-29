package bit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumProductofWordLengths_318 {
    public int maxProduct(String[] words) {
        int[] hashtable = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int bits = 0;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                int mask = 1;
                bits |= mask << (ch - 'a');
            }
            hashtable[i] = bits;
        }


        int len = words.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String word1 = words[i];
                String word2 = words[j];
                int b1 = hashtable[i];
                int b2 = hashtable[j];
                int r = b1 & b2;
                if (r == 0) {
                    result = Math.max(result, word1.length() * word2.length());
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new MaximumProductofWordLengths_318().maxProduct(words));
    }
}
