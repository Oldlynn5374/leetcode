package test;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int w = in.nextInt();
            int counter = 0;

            int[] a = new int[n];
            int[] b = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
                b[j] = in.nextInt();
            }

            int[] h = new int[n]; // h[i] = b[i] / a[i];
            int max = Integer.MIN_VALUE;
            int maxPos = 0;
            while (true) {
                boolean isOver = false;
                for (int j = 0; j < n; j++) {
                    counter++;
                    h[j] = b[j] / a[j];
                    if (h[j] > max) {
                        maxPos = j;
                        max = h[j];
                    }
                    a[j] -= b[j];
                    if (a[j] < 0) {
                        if (a[j] + w < 0) {
                            isOver = true;
                            break ;
                        }else {
                            maxPos = j;
                        }
                    }
                }
                if (isOver) {
                    System.out.println(counter);
                    return;
                }
                a[maxPos] += b[maxPos] + w;
            }
        }
    }
}
