package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations/">Problem on leetcode</a>
 */
public class PermutationGenerator {

    public List<List<Integer>> generate(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums);
        return results;
    }

    private void backtrack(List<List<Integer>> results, ArrayList<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            results.add(new ArrayList<>(temp));
        } else {
            for (int number : nums) {
                if (temp.contains(number)) continue;   // Ensures uniqueness
                temp.add(number);
                backtrack(results, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
