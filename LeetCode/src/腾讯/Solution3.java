package 腾讯;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int time = 1;
            int result = 0;
            int n = in.nextInt();

            int[] tn = new int[n];
            int[] wn = new int[n];

            for (int j = 0; j < n; j++) {
                tn[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                wn[j] = in.nextInt();
            }

            Map<Integer, List<Integer>> gameMap = new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            for (int j = 0; j < n; j++) {
                int t = tn[j];
                int w = wn[j];
                List list = gameMap.get(t);
                if (list == null) {
                    List l = new ArrayList();
                    l.add(w);
                    gameMap.put(t, l);
                }else {
                    list.add(w);
                }
            }

            Set<Map.Entry<Integer, List<Integer>>> entries = gameMap.entrySet();
            for (Map.Entry<Integer, List<Integer>> entry : entries) {
                int gameTime = entry.getKey();
                List<Integer> list = entry.getValue();
                list.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

                while (true) { // 时间充裕时
                    if (time > gameTime) {
                        for (int t : list) {
                            result += t;
                        }
                        break;
                    }
                    if (list.size() == 0) {
                        break;
                    }
                    list.remove(0);
                    time++;
                }
            }
            System.out.println(result);
        }

    }
}
