package DS;

import java.util.Stack;

public class ImplementQueueWithStacks_232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public ImplementQueueWithStacks_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        Integer value = stack2.pop();
        if (value == 0) {
            return -1;
        }else {
            return value;
        }
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        Integer value = stack2.peek();
        if (value == null) {
            return -1;
        }else {
            return value;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
