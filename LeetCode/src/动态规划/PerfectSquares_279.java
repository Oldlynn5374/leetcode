package 动态规划;

import java.util.*;

public class PerfectSquares_279 {
    public int numSquares(int n) {

        Set<Integer> result1 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        Set<Integer> result2 = new HashSet<>();
        Set<Integer> result4 = new HashSet<>();
        result4.add(7);
        result4.add(15);
        result4.add(23);
        result4.add(28);
        int count = 0;
        int value4 = 31;
        while (true){
            if (value4 > n){
                break;
            }
            count++;
            result4.add(value4);
            if (count % 5 ==1 || count % 5 == 2|| count % 5 == 3){
                value4 += 8;
            }else if (count % 5 == 4){
                value4 += 5;
            }else if (count % 5 == 0){
                value4 += 3;
            }

        }

        int filter1 = 1;
        while (true){
            Integer value = filter1 * filter1;
            if (value > n){
                break;
            }
            result1.add(value);
            list1.add(value);
            filter1++;
        }


        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                Integer value = new Integer(list1.get(i) + list1.get(j));
                result2.add(value);
            }
        }

        if (result1.contains(n)){
            return 1;
        }else if (result2.contains(n)){
            return 2;
        }else if (result4.contains(n)){
            return 4;
        }else {
            return 3;
        }

    }

    public int numSquares2(int n){
        int[] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j*j <= i ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares_279 perfectSquares = new PerfectSquares_279();
        System.out.println(perfectSquares.numSquares(112));
        for (int i = 0; i < 150; i++) {
            if(perfectSquares.numSquares2(i) == 4){
                System.out.println(i);
            }
        }
    }
}
