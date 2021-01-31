package BFS.WordLadderII_126;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> tVisited = new HashSet<>();
        Map<String,List<String>> sons = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        visited.add(beginWord);
        List<String> neighbors;
        boolean isFound = false;

        while (!queue.isEmpty()){
            int size = queue.size();
            String curWord = null;
            visited.addAll(tVisited);
            tVisited.clear();

            for (int i = 0; i < size; i++) {
                curWord = queue.poll();
                if (curWord.equals(endWord)){ // 找到了 endWord
                    break;
                }
              /*  if (visited.contains(curWord)){
                    continue;
                }*/

                //tVisited.add(curWord);
                neighbors = getNeighbors(dict, curWord);

                List<String> son = sons.get(curWord);
                if (null == son){
                    sons.put(curWord,new ArrayList<>());
                    son = sons.get(curWord);
                }

                for (String neighbor : neighbors){

                    if (!visited.contains(neighbor) || neighbor.equals(endWord)){
                        tVisited.add(neighbor);
                        if (!son.contains(neighbor)){
                            son.add(neighbor);
                        }

                        queue.offer(neighbor);
                        if (neighbor.equals(endWord)){
                            isFound = true;
                        }
                    }
                }

            }

            if(isFound){
                break;
            }

        }

        dfs(results,result,sons,beginWord,endWord);


        return results;
    }

    public void dfs (List<List<String>> results, List<String> result, Map<String,List<String>> sons, String word, String endWord){

        List<String> sub = sons.get(word);

        if (word.equals(endWord)){
            result.add(word);
            results.add(new ArrayList<>(result));
            result.remove(word);
            return;
        }
        if (sub == null){
            return;
        }

        result.add(word);
        for (String s : sub){
            dfs(results, result, sons, s, endWord);
        }
        result.remove(word);
    }

    public List<String> getNeighbors(Set<String> dict, String word){
        List<String> neighbors = new ArrayList<>();

        char[] chars = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++){
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ch){
                    continue;
                }
                char old = chars[i];
                chars[i] = ch;
                String value = String.valueOf(chars);
                if (dict.contains(value)){
                    neighbors.add(value);
                }
                chars[i] = old;
            }
        }

        return neighbors;
    }

    public static void main(String[] args) {
        WordLadderII wordLadder = new WordLadderII();
        List<String> wordList = new ArrayList<>();
        String[] ss = {"hot","dot","dog","lot","log","cog"};
        String[] ss2= {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String[] ss3 = {"ted","tex","red","tax","tad","den","rex","pee"};
        String[] ss4={"hot","dot","dog","lot","log","cog"};

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
    }
}
