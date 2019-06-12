package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/3sum/">Problem on leetcode</a>
 */
public class ThreeSumFinder {

    public List<List<Integer>> find(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }

        }

        return new ArrayList<>(res);
    }

}
