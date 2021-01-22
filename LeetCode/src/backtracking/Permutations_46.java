package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i : nums){
            numList.add(i);
        }

        //backtracking(numList,0,results);
        backtracking2(numList,result,results);
        return results;
    }

    public void backtracking(List<Integer> nums,int level,List<List<Integer>> result){

        if (level == nums.size()-1){
            List<Integer> r = new ArrayList<>(nums);
            result.add(r);
            return;
        }

        for (int i = level; i < nums.size(); i++){
            int iV = nums.get(i);
            int lV = nums.get(level);
            nums.set(i,lV);
            nums.set(level,iV);

            backtracking(nums,level + 1, result);

            iV = nums.get(i);
            lV = nums.get(level);
            nums.set(i,lV);
            nums.set(level,iV);

        }

    }








    public void backtracking2(List<Integer> nums,List<Integer> result,List<List<Integer>> results){

        if (0 == nums.size()){
            results.add(new ArrayList<>(result));
           // result.remove(result.size()-1);
            return;
        }

        for (int i = 0; i < nums.size(); i++){
            Integer value = nums.get(i);
            result.add(value);
            nums.remove(value);

            backtracking2(nums, result, results);

            nums.add(i,value);
            result.remove(value);
            
        }

    }

    public static void main(String[] args) {
        Permutations_46 permutations = new Permutations_46();
        int[] a = new int[]{1,2,3};
        List<List<Integer>> result = permutations.permute(a);
        for (List<Integer> list : result){

            for (int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
