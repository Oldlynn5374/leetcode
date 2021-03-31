package utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {

        Integer i1 = new Integer(4);
        Integer i2 = i1;
        i1 = 3;
        System.out.println(i2);

    }



}

class MinStack {

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else{

            if (x <= minStack.peek()){
                minStack.push(x);
            }
        }

    }

    public void pop() {
        int num = stack.pop();
        int min = minStack.peek();
        if (num == min){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);

        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }
}
