package 网易;

import java.util.Scanner;

public class Soultion2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int w = in.nextInt();
            int h = in.nextInt();

            String[] ways = new String[h];
            int count = 0;
            for(int j = 0; j < h; j++) {
                ways[count++] = in.next();
            }


            // 找出 S 和 E 的位置
            int[] SPOS = new int[2];
            int[] EPOS = new int[2];
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (ways[j].charAt(k) == 'S') {
                        SPOS[0] = j;
                        SPOS[1] = k;
                    }else if (ways[j].charAt(k) == 'E') {
                        EPOS[0] = j;
                        EPOS[1] = k;
                    }
                }
            }



            // 走迷宫

            // 获取 S 出发时的方向
            int[] dir = new int[4]; // 0:up 1:down 2:left 3:right
            // 人物坐标
            int x = SPOS[0];
            int y = SPOS[1];
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0 : if (x - 1 < 0 || ways[x - 1].charAt(y) == '#') dir[j] = 0; else dir[j] = 1;break;
                    case 1 : if (x + 1 >= h || ways[x + 1].charAt(y) == '#') dir[j] = 0;else dir[j] = 1;break;
                    case 2 : if (y - 1 < 0 || ways[x].charAt(y - 1) == '#') dir[j] = 0;else dir[j] = 1;break;
                    case 3 : if (y + 1 >= w || ways[x].charAt(y + 1) == '#') dir[j] = 0;else dir[j] = 1;
                }
            }

            int direction = 0;
            for (int j = 0; j < 4; j++) {
                if (dir[j] == 1) {
                    direction = j;
                    break;
                }
            }

            // 出发！
            int counter = 1;
            while (true) {
                if (ways[x].charAt(y) == 'E') {
                    System.out.println(counter);
                    break;
                }


                // 左转
                switch (direction) {
                    case 0 : direction = 2;break;
                    case 1 : direction = 3;break;
                    case 2 : direction = 1;break;
                    case 3 : direction = 0;
                }

                // 确定这一步的方向
                loop:
                while (true) {
                    switch (direction) {

                        case 0 : if (x - 1 < 0 || ways[x - 1].charAt(y) == '#') {
                            direction = 3;
                            continue;
                        }else {
                            counter++;
                            x--;
                            break loop;
                        }

                        case 1 : if (x + 1 >= h || ways[x + 1].charAt(y) == '#') {
                            direction = 2;
                            continue;
                        }else {
                            counter++;
                            x++;
                            break loop;
                        }

                        case 2 :if (y - 1 < 0 || ways[x].charAt(y - 1) == '#') {
                            direction = 0;
                            continue ;
                        }else {
                            counter++;
                            y--;
                            break loop;
                        }

                        case 3 : if (y + 1 >= w || ways[x].charAt(y + 1) == '#') {
                            direction = 1;
                            continue ;
                        }else {
                            counter++;
                            y++;
                            break loop;
                        }
                    }
                }
            }

        }
    }


}
