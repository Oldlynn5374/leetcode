package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            backtracking(nums,i,result,results);
        }

        return results;
    }

    public void backtracking(int[] nums, int pos, List<Integer> result, List<List<Integer>> results){

        if (pos >= nums.length){
            return;
        }
        Integer n = nums[pos];
        result.add(n);
        if (result.size() == 3){
            int sum = 0;
            for (int i : result){
                sum += i;
            }
            if (sum == 0){
                result.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1 > o2){
                            return 1;
                        }else if (o1 < o2){
                            return -1;
                        }
                        return 0;
                    }
                });
                List<Integer> rl = new ArrayList<>(result);
                if (results.contains(rl)){

                }else {
                    results.add(new ArrayList<>(result));
                }

            }
            result.remove(n);
            return;

        }
        for (int i = pos + 1; i < nums.length; i++) {
            backtracking(nums, i , result, results);
        }
        result.remove(n);

    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++){
            if (nums[i] > 0){
                return results;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0){
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);

                    results.add(new ArrayList<>(result));
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new ThreeSum_15().threeSum2(nums);
        for (List<Integer> list : lists){
            for (Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
