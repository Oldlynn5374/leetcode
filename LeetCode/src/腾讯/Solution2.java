package 腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        List<List<Integer>> timeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            timeList.add(new ArrayList<Integer>());
            timeList.get(i).add(in.nextInt());
        }

        for (List<Integer> arr : timeList) {
            for (int i = 1; i < k; i++) {
                arr.add((i + 1) * arr.get(0));
            }
        }

        for (int i = 0; i < k; i++) {
            int minId = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < timeList.size(); j++) {
                int value = timeList.get(j).get(0);
                if (value < minValue) {
                    minId = j;
                    minValue = value;
                }
            }
            timeList.get(minId).remove(0);
            System.out.println(minId + 1);
        }
    }
}
