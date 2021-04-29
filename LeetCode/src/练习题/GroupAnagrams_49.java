package 练习题;

import java.util.*;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> strList = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> results = new ArrayList<>();

        while (strList.size() != 0) {
            String mother = strList.get(0);
            strList.remove(0);
            List<String> res = new ArrayList<>();
            res.add(mother);
            Map<Character, Integer> charNum = new HashMap<>();

            if (mother.length() == 0) {
                charNum.put('@', 1);
            }
            for (int i = 0; i < mother.length(); i++) {
                char c = mother.charAt(i);
                Integer val = charNum.get(c);
                if (val == null) {
                    charNum.put(c, 1);
                }else {
                    charNum.put(c, val + 1);
                }
            }

            Iterator<String> iterator = strList.iterator();

            loop:
            while (iterator.hasNext()) {
                Map<Character, Integer> map = new HashMap<>(charNum);
                String member = iterator.next();

                if (member.length() == 0) {
                    Integer val = map.get('@');
                    if (val == null || val <= 0) {
                        continue;
                    }else {
                        if (val == 1) {
                            map.remove('@');
                        }else {
                            map.put('@', val - 1);
                        }
                    }
                }

                for (int i = 0; i < member.length(); i++) {
                    char c = member.charAt(i);
                    Integer val = map.get(c);
                    if (val == null || val <= 0) {
                        continue loop;
                    }else {
                        if (val == 1) {
                            map.remove(c);
                        }else {
                            map.put(c, val - 1);
                        }
                    }
                }

                if (map.size() == 0) {
                    res.add(member);
                    iterator.remove();
                }
            }

            results.add(res);
        }
        return results;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> results = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            List<String> list = results.getOrDefault(sortedStr, new ArrayList<>());
            list.add(strs[i]);
            results.put(sortedStr, list);
        }

        return new ArrayList<>(results.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> results = new GroupAnagrams_49().groupAnagrams2(strs);
        for (List<String> result : results) {
            for (String s : result) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
