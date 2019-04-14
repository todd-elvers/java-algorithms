package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations/">Problem on leetcode</a>
 */
public class UniquePermutationGenerator {

    public List<List<Integer>> generate(int[] nums) {
        // This ensures our simple duplicate check of nums[i]==nums[i-1] always works
        Arrays.sort(nums);

        return backtrack(
                new ArrayList<>(),
                new ArrayList<>(),
                nums,
                new boolean[nums.length]
        );
    }

    private List<List<Integer>> backtrack(List<List<Integer>> results, ArrayList<Integer> temp, int[] nums, boolean[] isUsed) {
        if(temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(isCurrentValueSkippable(i, nums, isUsed)) continue;

                isUsed[i] = true;
                temp.add(nums[i]);

                backtrack(results, temp, nums, isUsed);

                isUsed[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

        return results;
    }

    /**
     * Returns true if, and only if, the current value has been used OR if
     * the current value is unused, and it equals the previous value which
     * is also unused.
     */
    private boolean isCurrentValueSkippable(int i, int[] nums, boolean[] isUsed) {
        if(isUsed[i]) return true;

        return i > 0 && nums[i] == nums[i-1] && !isUsed[i-1];
    }

}
