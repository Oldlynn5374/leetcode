package 二分查找;

public class SearchInRotatedSortedArray_81 {

    public boolean search(int[] nums, int target) {
        if ( nums == null ||nums.length == 0 ){
            return false;
        }

        if (nums[0] < nums[nums.length - 1]){
            return binarySearch(nums,target,0,nums.length - 1);
        }

        int minPos = findMinPos(nums);
        int value = nums[0];
        if (value == target){
            return true;
        }else if (value > target){
            return binarySearch(nums,target,minPos,nums.length - 1);
        }else {
            return binarySearch(nums,target,0,minPos);
        }

    }

    public int findMinPos(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int midValue;
        int lValue;
        int rValue;


        while (true){
            mid = (left + right) >>> 1;
            midValue = nums[mid];
            lValue = nums[left];
            rValue = nums[right];

            if (mid == left){

                return midValue <= rValue ? mid : right;

            }else if (midValue < lValue){

                right = mid;

            }else if (midValue > lValue){

                left = mid;
            }else {
                left++;
            }

        }
    }

    public int findMinPosition(int[] nums){

        int left = 0;
        int right = nums.length - 1;
        int mid;
        int midValue;
        int rValue;

        mid = (left + right) >>> 1;

        if (nums[0] == nums[nums.length - 1]){
            left = mid;
        }


        while (true){
            mid = (left + right) >>> 1;
            midValue = nums[mid];
            rValue = nums[right];

            if (mid == left){

                return midValue <= rValue ? mid : right;

            }else if (midValue <= rValue){

                right = mid;

            }else if (midValue > rValue){

                left = mid;

            }




        }

    }

    public boolean binarySearch(int[] nums, int target, int left, int right){

        int mid;
        int midValue;

        while (left <= right){
            mid = (left + right) >>> 1;
            midValue = nums[mid];
            if (midValue == target){
                return true;
            }else if (midValue < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
/*        System.out.println( new SearchInRotatedSortedArray_81().findMinPosition(nums) );
        System.out.println(new SearchInRotatedSortedArray_81().binarySearch(nums,1,0,nums.length - 1));*/
        //System.out.println(new SearchInRotatedSortedArray_81().search(nums,-6));
        int nums2[] = new int[]{7,8,1,2,3,4,5};
        System.out.println(nums.length);
        System.out.println(new SearchInRotatedSortedArray_81().findMinPos(nums));
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 2){
                System.out.println(i);
                break;
            }
        }
    }

}
