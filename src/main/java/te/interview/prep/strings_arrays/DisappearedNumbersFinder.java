package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Problem on
 * leetcode</a>
 */
public class DisappearedNumbersFinder {

    public List<Integer> find(int[] nums) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int valueAsIndex = Math.abs(nums[i]) - 1;

            // Flag as negative the value nums[i] would have been in
            // if nums was sorted e.g. value 7 means set nums[6] to negative
            if (nums[valueAsIndex] > 0) {
                nums[valueAsIndex] = -nums[valueAsIndex];
            }
        }

        // Any non-negative index is a missing index
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            } else {
                // Undo modifications to `nums`
                nums[i] = -nums[i];
            }
        }

        return results;
    }

}
