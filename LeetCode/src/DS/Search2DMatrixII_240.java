package DS;

public class Search2DMatrixII_240 {

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int x = 0;
        int y = m;
        while (true) {
            if (x < 0 || y < 0 || x > n || y > m) {
                return false;
            }
            int value = matrix[x][y];
            if (value == target) {
                return true;
            }

            if (target < value) {
                y--;
            }else {
                x++;
            }
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int x = 0, y = 0;
        return isExist(matrix, target, x, y, n, m);
    }

    public boolean isExist(int[][] matrix, int target, int x, int y, int n, int m) {
        if (x > n || y > m || x < 0 || y < 0) {
            return false;
        }

        int a = (x + n) >> 1;
        int b = (y + m) >> 1;
        int value = matrix[a][b];

        if (value == target) {
            return true;
        } else {
            if ((n - x) == (m - y) && (m - y) == 0) {
                return false;
            }
        }

        if (value > target) {
            return isExist(matrix, target, x, y, n, b - 1) || isExist(matrix, target, x, y, a - 1, m);
        } else {
            return isExist(matrix, target, a + 1, y, n, m) || isExist(matrix, target, x, b + 1, n, m);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        };
        Search2DMatrixII_240 search = new Search2DMatrixII_240();
        for (int[] m : matrix) {
            for (int i : m) {
                System.out.println(search.searchMatrix2(matrix, i));
            }
        }
        System.out.println(search.searchMatrix(matrix, 31));
    }
}
