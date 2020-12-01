package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlap {
    public static int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        int total = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] < prev){
                total++;
            }else {
                prev = intervals[i][1];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{ {1,2}, {2,3} };
        int sum = EraseOverlap.eraseOverlapIntervals(test);

        for (int[]a : test){
            System.out.println(a[0] + " " + a[1]);
        }

        System.out.println(sum);
    }
}
