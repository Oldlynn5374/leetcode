package 其他.腾讯;

public class KthLargestElementInAnArray_215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        k = len - k;
        return findK(nums, k, 0, nums.length - 1);
    }

    public int findK(int[] nums, int k, int begin, int end) {
        if (begin > end) {
            return -1;
        }

        int pos = partition(nums, begin, end);
        if (pos == k) {
            return nums[pos];
        } else if (pos > k) {
            return findK(nums, k, begin, pos - 1);
        }else {
            return findK(nums, k, pos + 1, end);
        }
    }

    public int partition(int[] nums, int begin, int end){
        int p = nums[begin];
        while (begin < end) {
            while (begin < end && nums[end] >= p) {
                end--;
            }
            nums[begin] = nums[end];

            while (begin < end && nums[begin] <= p) {
                begin++;
            }
            nums[end] = nums[begin];
        }
        nums[begin] = p;

        return begin;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(new KthLargestElementInAnArray_215().findKthLargest(nums, k));
    }
}
