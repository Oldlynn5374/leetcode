package 双指针;

public class SearchRange_34 {
    public static int[] searchRange(int[] nums, int target) {



        int [] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums.length == 0){
            return result;
        }

        int l = 0;
        int r = nums.length - 1;
        boolean first = false;
        boolean last = false;


        while (l <= r){
            if (nums[l] == target){
                first = true;
                result[0] = l;
                result[1] = l;
            }

            if (nums[r] == target){
                last = true;
                result[1] = r;
            }

            if (first && last){
               break;
            }

            if (!first){
                l++;
            }
            if (!last){
                r--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 10;
        int[] result = SearchRange_34.searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
