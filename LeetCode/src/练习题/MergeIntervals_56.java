package 练习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] left = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                int[] right = intervals[j];

                if (left[0] > right[0]) {
                    left = right;
                    i = j;
                    continue;
                }

                if (right[0] <= left[1]) {
                    if (left[1] > right[1]) {

                    }else {
                        left[1] = right[1];
                    }
                    i = j;
                }else {
                    break;
                }
            }
            res.add(left);
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new MergeIntervals_56().merge(intervals);
        for (int[] ints : merge) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
