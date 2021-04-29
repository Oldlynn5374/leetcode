package 阿里;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n][m];

        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        Main main = new Main();
        main.dfs(matrix, x1 - 1, y1 - 1, x2 - 1, y2 - 1, 0, Integer.MIN_VALUE);
        System.out.println(main.min - 1);
    }

    public int min = Integer.MAX_VALUE;

    private  void dfs(int[][] matrix, int x, int y, int x2, int y2, int count, int lastVal) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return;
        }

        int val = matrix[x][y];
        if (val < lastVal) {
            return;
        }else {
            count++;
            matrix[x][y] = -1;
            if (x == x2 && y == y2) {
                min = Math.min(min, count);
                return;
            }
            dfs(matrix, x - 1, y, x2, y2, count, val);
            dfs(matrix, x, y - 1, x2, y2, count, val);
            dfs(matrix, x + 1, y, x2, y2, count, val);
            dfs(matrix, x, y + 1, x2, y2, count, val);
        }
    }
}
