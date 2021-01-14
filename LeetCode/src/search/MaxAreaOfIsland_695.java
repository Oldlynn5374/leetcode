package search;


public class MaxAreaOfIsland_695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0){
            return 0;
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++){
            for (int k = 0; k < grid[i].length; k++){
                if (0 == grid[i][k]){
                    continue;
                }
                sum = count(grid,i,k);
                if (sum > max){
                    max = sum;
                }
            }
        }

        return max;
    }

    public int count(int[][] grid,int i,int k) {

        int sum = 0;
        if (0 > i){
            return 0;
        }
        if (grid.length == i){
            return 0;
        }
        if (grid[i].length == k){
            return 0;
        }

        if (0 > k){
            return 0;
        }

        if (1 == grid[i][k]){
            sum++;
            grid[i][k] = 0;

            sum += count(grid,i-1,k);
            sum += count(grid,i+1,k);
            sum += count(grid,i,k - 1);
            sum += count(grid,i,k + 1);
        }

        return sum;
    }



    public static void main(String[] args) {
        MaxAreaOfIsland_695 max = new MaxAreaOfIsland_695();
        int[][] a = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,1,1,0,1,0,0,0,0,0,0,0,0},
                     {0,1,0,0,1,1,0,0,1,0,1,0,0},
                     {0,1,0,0,1,1,0,0,1,1,1,0,0},
                     {0,0,0,0,0,0,0,0,0,0,1,0,0},
                     {0,0,0,0,0,0,0,1,1,1,0,0,0},
                     {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] b = {{0}};

        int n = max.maxAreaOfIsland(b);
        //int n =max.count(b,0,0);
        System.out.println(n);


    }

}
