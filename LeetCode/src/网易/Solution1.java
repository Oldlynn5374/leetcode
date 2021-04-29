package 网易;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<String, Integer> userMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            String id = in.next();
            String name = in.next();
            Integer value = userMap.get(name);
            if (value == null) {
                userMap.put(name, 1);
            }else {
                userMap.put(name, value + 1);
            }
        }

        int count = 0;
        Set<Map.Entry<String, Integer>> entries = userMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() >= 2) {
                count++;
            }
        }

        System.out.println(count);
    }
}
