package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/combination-sum/">Problem on leetcode</a>
 */
public class CombinationSumFinder {

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
        if(remaining < 0) return results;

        if(remaining == 0) {
            results.add(new ArrayList<>(temp));
        } else {
            for(int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(results, temp, nums, i, remaining - nums[i]);
                temp.remove(temp.size() - 1);
            }
        }

        return results;
    }

}
