package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/combination-sum/">Problem on leetcode</a>
 */
public class CombinationSumFinder {

    public List<List<Integer>> findAll(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), candidates, 0, target);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> temp, int[] nums, int start, int remaining) {
        if (remaining == 0) {
            results.add(new ArrayList<>(temp));
        } else if (remaining > 0) {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                // Not i+1 b/c our output is allowed to reuse values
                backtrack(results, temp, nums, i, remaining - nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
