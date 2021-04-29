package 练习题;

import java.util.*;

public class SkylineProblem_218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings.length == 0) {
            return res;
        }
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        heap.offer(0);

        int[][] left = buildings.clone();
        Arrays.sort(left, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[2] - o1[2];
                }
                return o1[0] - o2[0];
            }
        });

        int[][] right = buildings.clone();
        Arrays.sort(right, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int leftPos = 0;
        int rightPos = 0;
        while (leftPos < left.length || rightPos < right.length) {
            int lf, rf;
            int lh,rh;
            if (leftPos >= left.length) {
                lf = Integer.MAX_VALUE;
                lh = 0;
            }else {
                lf = left[leftPos][0];
                lh = left[leftPos][2];
            }
            if (rightPos >= right.length) {
                rf = Integer.MAX_VALUE;
                rh = 0;
            }else {
                rf = right[rightPos][1];
                rh = right[rightPos][2];
            }


            int height = heap.peek();
            int height2 = heap.peek();
            int x = 0;
            if (rf < lf) {
                // 遇到右端点
                heap.remove(rh);
                height2 = heap.peek();
                rightPos++;
                while (true) {
                    if (rightPos >= right.length) {
                        break;
                    }
                    int rf2 = right[rightPos][1];
                    int rh2 = right[rightPos][2];
                    if (rf == rf2) {
                        heap.remove(rh2);
                        height2 = heap.peek();
                        rightPos++;
                    }else {
                        break;
                    }
                }
                x = rf;

            } else if (lf < rf) {
                // 遇到左端点
                heap.offer(lh);
                height2 = heap.peek();
                leftPos++;
                x = lf;

            } else if (lf == rf) {
                // 同时遇到左端点和右端点
                heap.remove(rh);
                heap.offer(lh);
                height2 = heap.peek();
                leftPos++;
                rightPos++;
                x = lf;
            }

            if (height != height2) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(height2);
                res.add(list);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {{4,9,10},{4,9,15},{4,9,12},{10,12,10},{10,12,8}};
        List<List<Integer>> skyline = new SkylineProblem_218().getSkyline(buildings);
        for (List<Integer> list : skyline) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
