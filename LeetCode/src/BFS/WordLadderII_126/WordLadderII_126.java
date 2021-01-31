package BFS.WordLadderII_126;

import java.util.ArrayList;
import java.util.List;

public class WordLadderII_126 {
    private Integer min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        if (wordList.lastIndexOf(endWord) == -1) {
            return results;
        }

        List<String> result = new ArrayList<>();
        result.add(beginWord);
        backtracking(results, result, wordList, beginWord, endWord, 0);
        if (results.size() == 0) {
            return results;
        }
    /*    int mini = results.get(0).size();
        List<List<String>> rml = new ArrayList<>();
        for (List<String> list : results){
            int size = list.size();
            if (size <= mini){
                mini = size;
            }
        }
        for (List<String> list : results){
            int size = list.size();
            if (size > mini){
                rml.add(list);
            }
        }
        results.removeAll(rml);*/


        return results;
    }

    public void backtracking(List<List<String>> results, List<String> result, List<String> wordList, String beginWord, String endWord, Integer count) {
        if (count > min){
            return;
        }
        String word = result.get(result.size() - 1);

        if (result.size() != 1) {

            if (word.equals(beginWord)) {
                return;
            }
            if (!isOK(word, result.get(result.size() - 2))) { // 新增的单词与上一个单词相差多于1位
                return;
            }
        }

        if (word.equals(endWord)) {


            if (count == min) {
                results.add(new ArrayList<>(result));
            }

            if (count < min) {
                results.clear();
                results.add(new ArrayList<>(result));
                min = new Integer(count);
            }


            return;
        }

        if (wordList.size() == 0) {
            return;
        }


        for (int i = 0; i < wordList.size(); i++) {

            String value = wordList.get(i);
            wordList.remove(i);
            result.add(value);

            backtracking(results, result, wordList, beginWord, endWord, count + 1);

            result.remove(result.size() - 1);
            wordList.add(i, value);

        }
    }

    public boolean isOK(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        boolean once = false;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (once) {
                    return false;
                }
                once = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordLadderII_126 wordLadder = new WordLadderII_126();
        List<String> wordList = new ArrayList<>();
        String[] ss = {"hat", "hot", "cat", "bat", "bot", "bit"};
        String[] ss2= {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};

        for (String s : ss2) {
            wordList.add(s);
        }
        List<List<String>> ladders = wordLadder.findLadders("qa", "sq", wordList);
        for (List<String> ladder : ladders) {
            for (String str : ladder) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
