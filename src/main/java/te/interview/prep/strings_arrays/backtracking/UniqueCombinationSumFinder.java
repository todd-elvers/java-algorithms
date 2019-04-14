package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/">Problem on leetcode</a>
 */
public class UniqueCombinationSumFinder {

    public List<List<Integer>> findAll(int[] candidates, int target) {
        Arrays.sort(candidates);

        return backtrack(
                new ArrayList<>(),
                new ArrayList<>(),
                candidates,
                0,
                target
        );
    }

    private List<List<Integer>> backtrack(List<List<Integer>> results, List<Integer> temp, int[] nums, int start, int remaining) {
        if (remaining == 0) {
            results.add(new ArrayList<>(temp));
        } else if (remaining > 0) {
            for (int i = start; i < nums.length; i++) {
                // Only perform the duplication check if we're not on the first iteration of this loop
                if(i != start && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                backtrack(results, temp, nums, i + 1, remaining - nums[i]);
                temp.remove(temp.size() - 1);
            }
        }

        return results;
    }

}
