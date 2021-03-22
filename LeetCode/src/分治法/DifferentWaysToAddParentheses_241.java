package 分治法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses_241 {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        if (map.get(input) != null){
            return map.get(input);
        }
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));

                for (int l : left){
                    for (int r : right){
                        switch (c){
                            case '+':ways.add(l + r);break;
                            case '-':ways.add(l - r);break;
                            case '*':ways.add(l * r);break;
                        }
                    }
                }
            }
        }

        if (ways.isEmpty()){
            ways.add(Integer.valueOf(input));
        }
        map.put(input, ways);
        return ways;
    }

    public List<Integer> diffWaysToCompute_dp(String input) {
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*'){
                opList.add(ch);
            }else{
                numList.add(Integer.valueOf(ch)-48);
            }
        }

        if (opList.size() == 0){
            return numList;
        }

        List<Integer> dp[][] = new ArrayList[numList.size()][numList.size()];

        // 初始化
        for (int i = 0; i < numList.size(); i++){
            dp[i][i] = new ArrayList<>();
            dp[i][i].add(numList.get(i));
        }

        for (int size = 2; size <= numList.size(); size++){
            for (int i = 0; i < numList.size(); i++){
                int j = i + size - 1;
                if (j >= numList.size()){
                    break;
                }
                for (int k = i; k < j; k++){
                    char op = opList.get(k);
                    for (Integer result1: dp[i][k]){
                        for (Integer result2 : dp[k+1][j]){
                            if (dp[i][j] == null){
                                dp[i][j] = new ArrayList<>();
                            }
                            dp[i][j].add(caculate(result1,op,result2));
                        }
                    }
                }
            }
        }

        return dp[0][numList.size()-1];
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(new DifferentWaysToAddParentheses_241().diffWaysToCompute(input));
        System.out.println(new DifferentWaysToAddParentheses_241().diffWaysToCompute_dp(input));
    }
}
