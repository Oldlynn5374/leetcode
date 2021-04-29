package DS;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n >> 1); i++) {
            int x = i ;
            for (int k = x; k < n - i - 1; k++) {
                int y = k;
                int[] nums = new int[4];
                for (int j = 0; j < 4; j++) {
                    nums[j] = matrix[x][y];
                    int tempX = x;
                    x = y;
                    y = n - 1 - tempX;
                }

                x = i;
                y = k;
                for (int j = 0; j < 4; j++) {
                    int pos = j - 1;
                    if (pos < 0) {
                        pos = 3;
                    }

                    matrix[x][y] = nums[pos];

                    int tempX = x;
                    x = y;
                    y = n - 1 - tempX;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}

        };
        new RotateImage_48().rotate(matrix);
        System.out.println();
    }
}
