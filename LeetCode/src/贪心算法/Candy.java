package 贪心算法;

import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int[] candyAllocate = new int[ratings.length];
        Arrays.setAll(candyAllocate, x -> 1);

        for (int i = 0 ; i < ratings.length - 1 ; i++){
          if (ratings[i] < ratings[i + 1]){

                candyAllocate[i+1] = candyAllocate[i] + 1;

            }
        }

        for (int j = ratings.length - 1 ; j > 0 ; j--){
            if (ratings[j - 1] > ratings[j]){

                if (candyAllocate[j - 1] <= candyAllocate[j] + 1){
                    candyAllocate[j - 1] = candyAllocate[j] + 1;
                }


            }
        }

        int sum = 0;
        for (int k : candyAllocate){
            sum += k;
        }

        return  sum;
    }

    public static void main(String[] args) {
        int a[] = new int[] {1,2,87,87,87,2,1};
        int sum = Candy.candy(a);
        System.out.println(sum);
    }
}
