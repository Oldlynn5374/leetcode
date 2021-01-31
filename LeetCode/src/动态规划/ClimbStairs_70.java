package 动态规划;

public class ClimbStairs_70 {
    /*
      标记法
     */
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        for (int i = 0; i < ways.length; i++) {
            if (0 == i){
                ways[0] = 0;
                continue;
            }
            if (1 == i){
                ways[1] = 1;
                continue;
            }
            if (2 == i){
                ways[2] = 2;
                continue;
            }
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    /*
    空间压缩
     */
    public int climbStairs2(int n) {
        if (n <=2 ){
            return n;
        }
        int p1 = 1;
        int p2 = 2;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = p1 + p2;
            p1 = p2;
            p2 = cur;
        }

        return cur;
    }


    public int ways(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        return ways(n - 1) + ways(n - 2);
    }

    public static void main(String[] args) {
        ClimbStairs_70 climbStairs = new ClimbStairs_70();
        int result = climbStairs.climbStairs2(5);
        System.out.println(result);
    }
}
