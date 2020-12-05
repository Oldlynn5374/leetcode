package 二分查找;

public class SearchRange_34 {

    public  int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] result = new int[2];
        result[0] = findFirstPosition(nums,target);
        if (result[0] == -1){
            result[1] = -1;
        }else {
            result[1] = findLastPosition(nums, target);
        }


        return result;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,7,7,8,8,10};
        int target = 2;
        int[] result = new SearchRange_34().searchRange(nums,target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int findFirstPosition(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right){
            mid = (left + right) >>> 1;

            if (nums[mid] == target){
                // 第一次出现的位置肯定不在右边，所以下次的查找位置是 [left,mid]
                right = mid;
            }else if (nums[mid] < target){
                // 第一次出现的位置肯定不在左边，所以下次的查找位置是 [mid + 1,right]
                left = mid + 1;
            }else {
                // 第一次出现的位置肯定不在右边，所以下次的查找位置是 [left,mid - 1]
                right = mid - 1;
            }
        }

        if (nums[left] == target){
            return left;
        }

        return -1;
    }

    public int findLastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right){
            mid = (left + right + 1) >>> 1;

            if (nums[mid] == target){
                //最后一次出现的区间在 [mid , right]
                left = mid;
            }else if (nums[mid] < target){
                //最后一次出现的区间在 [mid + 1 , right]
                left = mid + 1;
            }else {
                //最后一次出现的区间在 [left , mid - 1]
                right = mid - 1;
            }
        }

        if (nums[right] == target){
            return right;
        }


        return  -1;
    }
}
