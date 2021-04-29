package 练习题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return  new ArrayList<>();
        }

        List<String> father = new ArrayList<>();
        father.add("");

        for (int i = 0; i < n; i++) {
            father = generate(father);
        }

        return father;
    }

    public List<String> generate(List<String> father) {
        List<String> sons;
        StringBuilder result = new StringBuilder();
        Set<String> resultSet = new HashSet<>();

        for (String str : father) {
            result.setLength(0);
            result.append("()");
            result.append(str);
            String value = result.toString();

            resultSet.add(value);

            for (int i = 0; i < str.length(); i++) {
                char left = str.charAt(i);
                if (left == '(') {
                    for (int j = i; j < str.length(); j++) {
                        char right = str.charAt(j);
                        if (right == ')') {
                            result.setLength(0);
                            result.append(str);
                            result.insert(i, '(');
                            result.insert(j + 1, ')');
                            value = result.toString();

                            resultSet.add(value);

                        }
                    }
                }else {
                    continue;
                }
            }
            result.setLength(0);
            result.append(str);
            result.append("()");
            value = result.toString();

            resultSet.add(value);

        }
        sons = new ArrayList<>(resultSet);

        return sons;
    }

    public static void main(String[] args) {
       /* List<String> results = new ArrayList<>();
        List<String> father = new ArrayList<>();
        father.add("()()");
        List<String> sons = new GenerateParentheses_22().generate(results, father);
        for (String str : sons) {
            System.out.println(str);
        }*/

        List<String> results = new GenerateParentheses_22().generateParenthesis(1);
        for (String str : results) {
            System.out.println(str);
        }
    }
}
