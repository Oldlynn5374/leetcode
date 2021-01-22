package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
 /*       int[] nums = new int[k];
        backtracking(nums,0,1,result,n,k);*/

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            nums.add(i);
        }

        backtracking2(nums,result,results,k);

        return results;
    }

    public void backtracking(int[] nums,int count,int pos,List<List<Integer>> result,int n,int k){
       if (count == k){
           List<Integer> r = new ArrayList<>();
           for (int i : nums){
               r.add(i);
           }
           result.add(r);
           return;
       }

       for (int i = pos; i <= n; i++){
           nums[count++] = i;
           backtracking(nums, count, i + 1, result, n, k);
           count--;
       }
    }



    public void backtracking2(List<Integer> nums,List<Integer> result,List<List<Integer>> results,int k){

        if (result.size() == k){
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.size(); i++){
            Integer value = nums.get(i);
            result.add(value);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                list.add(nums.get(j));
            }
            nums.removeAll(list);

            backtracking2(nums, result, results, k);

            result.remove(value);
            for (int j = 0; j < list.size(); j++) {
                nums.add(j,list.get(j));
            }
        }

    }



    public static void main(String[] args) {
        Combination_77 combination = new Combination_77();
        List<List<Integer>> result = combination.combine(4,2);
        for (List<Integer> list : result){

            for (int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
