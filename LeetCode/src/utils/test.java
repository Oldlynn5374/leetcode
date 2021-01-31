package utils;

import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("a");
        queue.offer("1");

        while (queue.size() != 0){
            String value = queue.poll();
            System.out.println(value);
        }
    }

    public void testInteger(Integer integer){

    }
}
