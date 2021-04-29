package 练习题;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        List<String> letters = new ArrayList<>();
        if (digits.equals("")) {
            return results;
        }
        String[] letterMap = new String[10];
        letterMap[2] = "abc";
        letterMap[3] = "def";
        letterMap[4] = "ghi";
        letterMap[5] = "jkl";
        letterMap[6] = "mno";
        letterMap[7] = "pqrs";
        letterMap[8] = "tuv";
        letterMap[9] = "wxyz";


        for (int i = 0; i < digits.length(); i++) {
            int pos = Integer.valueOf(digits.charAt(i)) - 48;
            letters.add(letterMap[pos]);
        }

        backtracking(results, result, letters, 0);

        return results;
    }

    private void backtracking(List<String> results, StringBuilder result, List<String> letters, int pos) {
        if (pos >= letters.size()) {
            results.add(result.toString());
            return;
        }

        String str = letters.get(pos);
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));
            backtracking(results, result, letters, pos + 1);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> results = new LetterCombinationsofaPhoneNumber_17().letterCombinations(digits);
        for (String result : results) {
            System.out.print(result + " ");
        }

    }
}
