package 其他.腾讯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        results.add(new ArrayList<>(result));
        for (int i = 0; i < nums.length; i++) {
            backtracking(nums, i, result, results);
        }
        return results;
    }

    public void backtracking(int[] nums, int pos, List<Integer> result, List<List<Integer>> results){
        if (pos >= nums.length){
            return;
        }

        Integer value = nums[pos];
        result.add(value);
        results.add(new ArrayList<>(result));

        for (int i = pos + 1; i < nums.length; i++){
            backtracking(nums, i, result, results);
        }

        result.remove(value);
    }

    public static void main(String[] args) {
        int[] nums = {};
        List<List<Integer>> results = new SubSets_78().subsets(nums);
        for (List<Integer> result : results){
            for (Integer i : result){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
