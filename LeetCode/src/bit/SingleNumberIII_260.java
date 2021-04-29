package bit;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = 0;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            int m = mask & xor;
            if (m == 0) {

            }else {
                break;
            }
        }


        int res1 = 0;
        int res2 = 0;
        for (int num : nums) {
            int m = mask & num;
            if (m == 0) {
                res1 ^= num;
            }else {
                res2 ^= num;
            }
        }

        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] res = new SingleNumberIII_260().singleNumber(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
