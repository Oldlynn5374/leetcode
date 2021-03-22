package 其他.腾讯;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix_54 {
    private boolean[][] isVisited;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0){
            return result;
        }
        isVisited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, 0, 0, 0, result);
        return result;
    }

    public void dfs(int[][] matrix, int x, int y, int dir, List<Integer> result){
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || isVisited[x][y] == true){
            return;
        }

        result.add(matrix[x][y]);
        isVisited[x][y] = true;

        // 转下
        if (dir == 0 && (y >= matrix[0].length - 1 || isVisited[x][y + 1] == true)){
            dfs(matrix, x + 1, y, 1, result);
            return;
        }
        // 转左
        if (dir == 1 && (x >= matrix.length - 1 || isVisited[x + 1][y] == true)){
            dfs(matrix, x, y - 1, 2, result);
            return;
        }
        // 转上
        if (dir == 2 && (y == 0 || isVisited[x][y - 1])){
            dfs(matrix, x - 1, y, 3, result);
            return;
        }
        // 转右
        if (dir == 3 && (x == 0 || isVisited[x - 1][y])){
            dfs(matrix, x, y + 1, 0, result);
            return;
        }

        switch (dir){
            case 0 : dfs(matrix, x, y + 1, dir, result);break;
            case 1 : dfs(matrix, x + 1, y, dir, result);break;
            case 2 : dfs(matrix, x , y - 1, dir, result);break;
            case 3 : dfs(matrix, x - 1, y, dir, result);break;
        }


    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0){
            return result;
        }

        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;

        while (true){
            // 向右
            for (int i = l; i <= r ; i++) {
                result.add(matrix[u][i]);
            }
            if (++u > d)break;

            // 向下
            for (int i = u; i <= d; i++){
                result.add(matrix[i][r]);
            }
            if (--r < l)break;

            // 向左
            for (int i = r; i >= l; i--){
                result.add(matrix[d][i]);
            }
            if (--d < u)break;

            // 向上
            for (int i = d; i >= u; i--){
                result.add(matrix[i][l]);
            }
            if (++l > r)break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> result = new SpiralMatrix_54().spiralOrder2(matrix);
        for (int i : result){
            System.out.print(i + " ");
        }
    }
}
