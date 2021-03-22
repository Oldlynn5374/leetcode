package 其他.腾讯;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int max = 0;
        while (p1 < p2){
            int v1 = height[p1];
            int v2 = height[p2];
            if (v1 < v2){
                max = Math.max(max, (p2 - p1) * v1);
                p1++;
            }else {
                max = Math.max(max, (p2 - p1) * v2);
                p2--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {};
        System.out.println(new ContainerWithMostWater_11().maxArea(height));
    }
}
