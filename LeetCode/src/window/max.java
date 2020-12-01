package window;

public class max {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[]{};
        }
        if(k == 1){
            return nums;
        }
        int[]result = new int[nums.length - k + 1];
        int max = nums[0];

        int lastMax = nums[k-1];
        for(int j = 1;j < k;j++){

            if(nums[j]>lastMax){
                lastMax = nums[j];
            }
        }

        if(max<lastMax){
            max = lastMax;
        }

        result[0] = max;

        for(int i = 1;i < nums.length - k + 1;i++){
            max = nums[k+i-1];
            if(max<lastMax){
                max = lastMax;
            }
            result[i] = max;

            if(nums[i] == max){
                lastMax = nums[i+1];
                for(int x = i+1;x < i+k;x++){
                    if(nums[x]>lastMax){
                        lastMax = nums[x];
                    }
                }
            }else if(nums[i] != max){
                lastMax = max;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[]={7,4,2};
        int k =2;
        int [] result = new max().maxSlidingWindow(nums,k);
        for(int i : result){
            System.out.println(i);
        }
    }
}
