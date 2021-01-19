package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificWaterFlow_417 {
    public boolean isPacific;
    public boolean isAtlantic;
    public boolean isSame;

    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                isAtlantic = false;
                isPacific = false;
                int[][] temp = new int[matrix.length][matrix[0].length];
                for (int j = 0; j < matrix.length; j++) {
                    for (int o = 0; o < matrix[j].length; o++) {
                        temp[j][o] = matrix[j][o];
                    }
                }
                dfs2(temp, i, k);
                if (isPacific && isAtlantic) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(k);
                    result.add(list);
                }
                System.out.print(isPacific && isAtlantic);
                System.out.print(" ");
            }
            System.out.println();
        }


        return result;
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix.length == 0){
            return result;
        }

        can_reach_a = new boolean[matrix.length][matrix[0].length];
        can_reach_p = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++){
            dfs(matrix,can_reach_p,0,i);
            dfs(matrix,can_reach_a,matrix.length-1,i);
        }

        for (int j = 0; j < matrix.length; j++){
            dfs(matrix,can_reach_p,j,0);
            dfs(matrix,can_reach_a,j,matrix[0].length-1);
        }

        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix[0].length; y++){
                if (can_reach_p[x][y] && can_reach_a[x][y]){
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    result.add(list);
                }
                System.out.print(can_reach_p[x][y] && can_reach_a[x][y]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return result;
    }


    public boolean[][] can_reach_p;
    public boolean[][] can_reach_a;

    public void dfs(int[][] matrix, boolean[][] can_reach ,int i, int j) {

        if (can_reach[i][j]){
            return;
        }

        can_reach[i][j] = true;
        int value = matrix[i][j];

        if (i != 0 && value <= matrix[i - 1][j]) {
            dfs(matrix, can_reach,i - 1, j);
        }

        if (i < matrix.length - 1 && value <= matrix[i + 1][j]) {
            dfs(matrix, can_reach,i + 1, j);
        }

        if (j != 0 && value <= matrix[i][j - 1]) {
            dfs(matrix, can_reach, i, j - 1);
        }

        if (j < matrix[i].length - 1 && value <= matrix[i][j + 1]) {
            dfs(matrix, can_reach, i, j + 1);
        }

    }

    public void dfs2(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return;
        }
        int value = matrix[i][j] + 1;
        matrix[i][j] = value;

        if (i == 0 || j == 0) {
            isPacific = true;
        }

        if (i == matrix.length - 1 || j == matrix[i].length - 1) {
            isAtlantic = true;
        }

        if (isAtlantic && isPacific) {
            return;
        }

        if (i != 0 && value > matrix[i - 1][j]) {
            dfs2(matrix, i - 1, j);
        }

        if (i < matrix.length - 1 && value > matrix[i + 1][j]) {
            dfs2(matrix, i + 1, j);
        }

        if (j != 0 && value > matrix[i][j - 1]) {
            dfs2(matrix, i, j - 1);
        }

        if (j < matrix[i].length - 1 && value > matrix[i][j + 1]) {
            dfs2(matrix, i, j + 1);
        }


    }

    public static void main(String[] args) {
        PacificWaterFlow_417 pacific = new PacificWaterFlow_417();
        int[][] a = {
                {4, 4, 1, 7, 4, 18, 5, 5, 1, 6, 6, 10, 17, 19, 13, 3, 19},
                {19, 8, 3, 14, 18, 11, 2, 2, 5, 2, 19, 15, 18, 12, 16, 7, 19},
                {2, 4, 15, 2, 6, 4, 18, 13, 12, 11, 0, 11, 6, 19, 17, 11, 9},
                {10, 2, 0, 7, 13, 3, 7, 0, 5, 4, 10, 2, 3, 18, 10, 8, 10},
                {13, 16, 8, 5, 15, 12, 8, 14, 16, 18, 18, 19, 10, 14, 9, 4, 12},
                {0, 16, 14, 14, 13, 15, 2, 16, 1, 13, 17, 9, 6, 11, 17, 4, 13},
                {7, 9, 1, 5, 18, 15, 2, 1, 13, 3, 0, 7, 8, 8, 9, 12, 0},
                {7, 13, 14, 5, 3, 16, 5, 4, 5, 3, 9, 11, 11, 3, 1, 17, 12},
                {8, 18, 17, 9, 1, 0, 18, 7, 16, 15, 14, 14, 16, 8, 11, 13, 10},
                {14, 19, 19, 19, 19, 12, 2, 17, 17, 8, 10, 19, 16, 7, 10, 12, 17},
                {7, 0, 5, 2, 10, 7, 1, 0, 15, 3, 5, 2, 14, 16, 17, 9, 10},
                {11, 10, 15, 4, 17, 11, 17, 14, 18, 11, 17, 15, 19, 1, 9, 7, 17},
                {10, 8, 12, 15, 13, 3, 15, 14, 5, 4, 4, 4, 0, 11, 16, 14, 15},
                {16, 5, 3, 5, 13, 1, 6, 3, 8, 9, 3, 18, 11, 9, 7, 5, 14},
                {5, 7, 14, 13, 6, 12, 10, 6, 6, 12, 5, 0, 2, 0, 0, 15, 19},
                {14, 11, 17, 13, 6, 11, 15, 0, 6, 4, 5, 1, 15, 1, 19, 0, 14},
                {17, 5, 0, 0, 10, 13, 4, 10, 17, 5, 5, 6, 16, 19, 1, 11, 0},
                {14, 18, 11, 8, 0, 1, 0, 11, 1, 7, 15, 11, 4, 5, 18, 14, 19},
                {17, 10, 17, 17, 1, 17, 16, 16, 19, 15, 0, 14, 15, 2, 1, 18, 4},
                {12, 13, 0, 15, 16, 3, 1, 7, 10, 9, 0, 2, 13, 4, 7, 1, 15},
                {9, 6, 17, 12, 6, 19, 2, 15, 3, 14, 10, 15, 10, 11, 15, 13, 10},
                {2, 19, 4, 12, 19, 5, 18, 9, 4, 5, 1, 9, 17, 8, 14, 12, 15},
                {5, 1, 6, 17, 0, 15, 13, 3, 14, 13, 15, 4, 15, 11, 7, 15, 4},
                {14, 5, 6, 9, 11, 6, 4, 10, 16, 11, 6, 6, 0, 17, 13, 1, 10},
                {5, 18, 3, 15, 10, 6, 10, 6, 12, 5, 13, 2, 5, 7, 3, 3, 19},
                {11, 7, 17, 17, 8, 2, 11, 3, 0, 7, 16, 13, 7, 0, 12, 11, 14},
                {18, 1, 19, 7, 14, 9, 8, 2, 3, 16, 7, 9, 16, 4, 18, 8, 3},
                {5, 8, 19, 0, 10, 12, 9, 12, 10, 2, 11, 3, 15, 8, 18, 12, 3},
                {15, 2, 4, 9, 4, 4, 18, 12, 6, 10, 10, 3, 6, 6, 17, 3, 14},
                {18, 17, 13, 0, 12, 15, 3, 2, 15, 17, 8, 16, 8, 7, 17, 18, 2},
                {5, 12, 12, 17, 18, 11, 8, 6, 13, 13, 14, 18, 17, 9, 16, 8, 5},
                {16, 1, 9, 13, 6, 12, 15, 3, 12, 6, 2, 14, 10, 16, 11, 3, 8},
                {0, 7, 16, 3, 7, 0, 10, 10, 7, 3, 4, 18, 7, 18, 7, 15, 12},
                {8, 7, 12, 17, 8, 8, 18, 11, 7, 12, 18, 2, 19, 6, 6, 3, 13},
                {6, 19, 14, 9, 16, 9, 13, 13, 4, 11, 0, 0, 3, 1, 9, 10, 7},
                {0, 8, 14, 13, 1, 7, 7, 7, 2, 15, 12, 6, 10, 10, 3, 14, 8},
                {10, 17, 1, 8, 8, 16, 14, 18, 18, 1, 10, 12, 3, 13, 10, 6, 5},
                {8, 17, 17, 6, 2, 14, 5, 3, 7, 5, 4, 5, 13, 14, 17, 14, 15},
                {2, 6, 12, 4, 14, 11, 14, 3, 12, 10, 12, 15, 9, 7, 0, 4, 5},
                {13, 11, 5, 13, 12, 3, 19, 10, 16, 8, 3, 11, 7, 10, 0, 5, 18},
                {0, 18, 1, 8, 19, 11, 0, 1, 2, 19, 14, 11, 10, 15, 12, 3, 15}
        };

        int[][] b = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

  /*      pacific.dfs2(a,9,11);
        System.out.print(pacific.isPacific + " " + pacific.isAtlantic);
        System.out.println("-----------");*/

        List<List<Integer>> lists = pacific.pacificAtlantic(a);
        System.out.println("------------------------");
        for (List<Integer> list : lists) {
            System.out.print("( ");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println(")");
        }
    }
}
