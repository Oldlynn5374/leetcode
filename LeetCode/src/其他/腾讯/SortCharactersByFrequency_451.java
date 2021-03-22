package 其他.腾讯;

import java.util.*;

public class SortCharactersByFrequency_451 {
    public String frequencySort(String s) {
       Map<Character, Integer> map = new HashMap<>();
       for (int i = 0; i < s.length(); i++){
           Integer value = map.get(s.charAt(i));
           if (value == null){
               map.put(s.charAt(i), 1);
           }else {
               map.put(s.charAt(i), value + 1);
           }
       }

       List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
       list.sort(new Comparator<Map.Entry<Character, Integer>>() {
           @Override
           public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
               if (o1.getValue() > o2.getValue()){
                   return -1;
               }else if (o1.getValue() < o2.getValue()){
                   return 1;
               }
               return 0;
           }
       });

       StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list){
            Character c = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            Integer value = map.get(s.charAt(i));
            if (value == null){
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), value + 1);
            }
        }

        List<Character>[] characterList = new List[s.length() + 1];
        for (char key : map.keySet()){
            int value = map.get(key);
            if (characterList[value] == null) {
                characterList[value] = new ArrayList<>();
            }
            characterList[value].add(key);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = characterList.length - 1; i > 0; i--){
            if (characterList[i] == null){
                continue;
            }
            for (Character c : characterList[i]){
                for (int j = 0; j < map.get(c); j++){
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "";
        System.out.println(new SortCharactersByFrequency_451().frequencySort2(str));
    }
}
