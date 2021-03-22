package 其他.字节跳动;

import java.util.LinkedList;
import java.util.Queue;

public class ByteDance3 {
    int direction[] = {-1, 0, 1, 0, -1};

    public int countMinute(int[][] martix){
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                if (martix[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()){
            int len = queue.size();
            count++;
            for (int i = 0; i < len; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];

                for (int j = 0; j < 4; j++) {
                    int a = x + direction[j];
                    int b = y + direction[j + 1];

                    if (a >= martix.length || a < 0 || b >= martix[a].length || b < 0){
                        continue;
                    }

                    if (martix[a][b] == 1){
                        martix[a][b] = 2;
                        queue.offer(new int[]{a, b});
                    }
                }
            }

            System.out.println("======================");
            for (int i = 0; i < martix.length; i++) {
                for (int j = 0; j < martix[i].length; j++) {
                    System.out.print(martix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("======================");
        }

        return count - 1;
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1,1,2,1},
                {0,1,0,0},
                {1,1,1,0},
                {0,0,1,0}
        };

        System.out.println(new ByteDance3().countMinute(martix));
    }
}
