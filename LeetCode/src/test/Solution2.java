package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }


        while (true) {
            boolean isFound = false;
            int pos = 0;

            if (list.size() == 1) {
                break;
            }

            for (int i = 0; i < list.size() - 1; i++) {
                int cur = list.get(i);
                int next = list.get(i + 1);

                if (cur + next == 10) {
                    isFound = true;
                    pos = i;
                    break;
                }
            }
            if (isFound) {
                list.remove(pos);
                list.remove(pos);
            }else {
                break;
            }
        }

        System.out.println(list.size());
    }
}
