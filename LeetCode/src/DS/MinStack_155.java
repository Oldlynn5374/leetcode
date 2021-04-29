package DS;

import java.util.Stack;

public class MinStack_155 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private Integer top;

    public MinStack_155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
        top = val;
    }

    public void pop() {
        int value = stack.pop();
        if (minStack.peek() == value) {
            minStack.pop();
        }
        if (!stack.isEmpty()) {
            top = stack.peek();
        }
    }

    public int top() {
        return top;
    }

    public int getMin() {
        return minStack.peek();
    }
}
