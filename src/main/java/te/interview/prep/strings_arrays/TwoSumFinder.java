package te.interview.prep.strings_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Problem on leetcode</a>
 */
public class TwoSumFinder {

    /*
        Time : O(n)
        Space: O(n)
     */
    static class UsingHashMap {

        public int[] find(int[] nums, int target) {
            if (nums.length == 2) return new int[]{0, 1};

            Map<Integer, Integer> valueToIndex = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int compliment = target - nums[i];

                // i.e. have we seen a value already that, when subtracted from `target`,
                // equals a value already present in the array.
                if (valueToIndex.containsKey(compliment)) {
                    return new int[]{valueToIndex.get(compliment), i};
                } else {
                    valueToIndex.put(nums[i], i);
                }
            }

            throw new IllegalArgumentException("Expected a two sum solution but none was found.");
        }

    }

    /*
        Time : O(n^2)
        Space: O(1)
     */
    static class UsingBruteForce {

        public int[] find(int[] nums, int target) {
            if (nums.length == 2) return new int[]{0, 1};

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }

            throw new IllegalArgumentException("Expected a two sum solution but none was found.");
        }
    }

}
