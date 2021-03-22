package 其他.字节跳动;
/*
根据n打印以下方阵。
n = 3 时
1 2 3
8 9 4
7 6 5
n = 4时
1  2  3  4
12 13 14  5
11 16 15 6
10 9   8  7
也就是从外圈往里面以此增加。
 */
public class ByteDance {
    public void printMartix(int n){
        int[][] martix = new int[n][n];
        int dir = 0;// 0 : right  1 : left  2 : up  3 : down
        createMartix(martix, 0, 0, dir, 1);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(martix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void createMartix(int[][] martix,int x, int y, int dir, int count){
        if (martix[x][y] != 0){
            return;
        }

        martix[x][y] = count;

        // down
        if ( (x == martix.length - 1 || martix[x + 1][y] != 0 ) && dir == 0 ){
            createMartix(martix, x, y + 1, 3, count + 1);
            return;
        }

        // left
        if ( (y == martix[0].length - 1 || martix[x][y + 1] != 0) && dir == 3 ){
            createMartix(martix, x - 1, y, 1, count + 1 );
            return;
        }

        // up
        if ( (x == 0 || martix[x - 1][y] != 0) && dir == 1 ){
            createMartix(martix, x, y - 1, 2, count + 1);
            return;
        }

        // right
        if ( (y == 0 || martix[x][ y - 1] != 0) && dir == 2 ){
            createMartix(martix, x + 1, y, 0, count + 1);
            return;
        }

        if (dir == 0){
            createMartix(martix, x + 1, y, 0, count + 1);
        }else if (dir == 1){
            createMartix(martix, x - 1, y, 1, count + 1 );
        }else if (dir == 2){
            createMartix(martix, x, y - 1, 2, count + 1);
        }else if (dir == 3){
            createMartix(martix, x, y + 1, 3, count + 1);
        }
    }

    public static void main(String[] args) {
        new ByteDance().printMartix(10);
    }
}
