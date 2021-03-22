package 其他.腾讯;

public class SearchinRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;

        while (begin <= end){
            int mid = (begin + end) >> 1;
            if (nums[mid] == target){
                return mid;
            }
            int beginValue = nums[begin];
            int midValue = nums[mid];
            int endValue = nums[end];

            if (target < midValue){
                if (target < beginValue){
                    begin++;
                }else if (target == beginValue){
                    return begin;
                }else {
                    end = mid - 1;
                }
            }else {
                if (target == beginValue){
                    return begin;
                }
                if (target == endValue){
                    return end;
                }
                if (target < endValue){
                    begin = mid + 1;
                }else {
                    end--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new SearchinRotatedSortedArray_33().search(nums, 3));
    }
}
