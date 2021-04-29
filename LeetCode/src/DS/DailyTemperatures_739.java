package DS;

import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] result = new int[len];
        if (len <= 1) {
            return result;
        }

        stack.push(0);
        for (int i = 1; i < len; i++) {
            int value = T[i];
            int peek = stack.peek();
            int peekVal = T[peek];

            while (value > peekVal) {
                stack.pop();
                result[peek] = i - peek;
                if (stack.isEmpty()) {
                    break;
                }else {
                    peek = stack.peek();
                    peekVal = T[peek];
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new DailyTemperatures_739().dailyTemperatures(T);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
