package backtracking;

import java.util.*;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> results = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        backtracking(results, result, candidates, 0, target, 0);
        return new ArrayList<>(results);
    }

    public void backtracking(Set<List<Integer>> results, List<Integer> result, int[] candidates, int pos, int target, int sum) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            int candidate = candidates[i];

            result.add(candidate);
            sum += candidate;
            backtracking(results, result, candidates, i, target, sum);
            sum -= candidate;
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        List<List<Integer>> results = new CombinationSum_39().combinationSum(candidates, target);

        for (List<Integer> result : results) {
            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
