package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/subsets/">Problem on leetcode</a>
 */
public class PowersetGenerator {

    public List<List<Integer>> generate(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        backtrack(powerset, nums, new ArrayList<>(), 0);
        return powerset;
    }

    private void backtrack(List<List<Integer>> powerset, int[] nums, List<Integer> set, int start) {
        powerset.add(new ArrayList<>(set));

        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            backtrack(powerset, nums, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

}
