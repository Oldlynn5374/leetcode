package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestBridge_934 {

    public int shortestBridge(int[][] A) {
        List<int[]> oceans = new LinkedList<>();
        int[] direction = {-1, 0, 1, 0, -1};
        boolean first = false;
        for (int i = 0; i < A.length; i++) {
            if (first){
                break;
            }
            for (int j = 0; j < A[i].length; j++) {
                if (1 == A[i][j]){
                    dfs(A,i,j, oceans);
                    first = true;
                    break;
                }
            }
        }

     /*   System.out.println("-----------------------");
        for (int[]a : oceans){
            System.out.println("[" + a[0] + "," +a[1] + "]");
        }
        System.out.println("-----------------------");*/
        int count = 0;
        List<int[]> oceans2 = new LinkedList<>();
        while (true){
            if (0 == oceans.size()){
                if (0 != oceans2.size()){
                    oceans = new LinkedList<>(oceans2);
                    oceans2 = new LinkedList<>();
                    count++;
                }else {
                    break;
                }
            }


            int[] ocean = oceans.get(0);
            oceans.remove(0);
            int x = ocean[0];
            int y = ocean[1];
            if (1 == A[x][y]){
                return count;
            }

            if (2 == A[x][y]){
                continue;
            }

            A[x][y] = 2;

            for (int i = 0; i < 4; i++) {
                int r = x + direction[i];
                int c = y + direction[i + 1];

                if (r < 0 || c < 0 ||r >= A.length || c >= A[r].length){
                    continue;
                }

                if (0 == A[r][c] || 1 == A[r][c]){
                    oceans2.add(new int[]{r,c});
                }
            }

        }


        return 0;
    }

    public void dfs(int[][] A,int x, int y, List<int[]> oceans ){

        if (x < 0 || y < 0 || x >= A.length || y >= A[x].length){
            return;
        }

        if (2 == A[x][y]){
            return;
        }

        if (0 == A[x][y]){
            oceans.add(new int[]{x,y,});
            return;
        }

        A[x][y] = 2;
        dfs(A,x - 1, y, oceans);
        dfs(A, x + 1, y, oceans);
        dfs(A, x, y - 1, oceans);
        dfs(A, x, y + 1, oceans);

    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,1,0},{0,0,0},{0,0,1}} ;
     /*   for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.println("-----------------------");
        ShortestBridge_934 shortestBridge = new ShortestBridge_934();
        int result = shortestBridge.shortestBridge(A);
    /*    for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/

        System.out.println("------------------------");
        System.out.println("result: " + result);
    }


}
