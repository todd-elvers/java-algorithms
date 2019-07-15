package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/subsets-ii/">Problem on leetcode</a>
 */
public class UniquePowersetGenerator {

    public List<List<Integer>> generate(int[] nums) {
        // This ensures our simple duplicate check of nums[i]==nums[i-1] always works
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> powerset, List<Integer> set, int[] nums, int start) {
        powerset.add(new ArrayList<>(set));

        for (int i = start; i < nums.length; i++) {
            // Only perform the duplication check if we're not on the first iteration of this loop
            if (i != start && nums[i] == nums[i - 1]) continue;

            set.add(nums[i]);
            backtrack(powerset, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }

}
