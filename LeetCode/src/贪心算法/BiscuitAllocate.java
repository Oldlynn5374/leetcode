package 贪心算法;


import java.util.Arrays;

public class BiscuitAllocate {
    public int findContentChildren(int[] g, int[] s) {
        int sum = 0;
        int gp = 0;
        int sp = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        if(g.length == 0 || s.length == 0){
            return 0;
        }

        while(true){
            if(s[sp] >= g[gp]){
                sum++;
                sp++;
                gp++;
            }else{
                sp++;
            }

            if(s.length <= sp || g.length <= gp){
                return sum;
            }
        }
    }
}
