package 其他.腾讯;

import java.util.Stack;

public class AvailableBrac_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char brac = s.charAt(i);
            switch (brac) {
                case '(' : ;
                case '[' : ;
                case '{' : stack.push(brac);break;
                case ')' : if (stack.isEmpty() || stack.pop() != '(')return false;else break;
                case ']' : if (stack.isEmpty() || stack.pop() != '[')return false;else break;
                case '}' : if (stack.isEmpty() || stack.pop() != '{')return false;else break;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(new AvailableBrac_20().isValid(s));
    }
}
