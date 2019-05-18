package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/summary-ranges/">Problem on leetcode</a>
 */
public class SummaryRangeFinder {
    private static final String DELIMITER = "->";

    public List<String> find(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<String> ranges = new ArrayList<>();
        Integer start = null, end = null;
        for (int i = 0; i < nums.length; i++) {
            if (start == null) {
                start = end = nums[i];
                continue;
            }

            if (Math.abs(nums[i] - end) > 1) {
                ranges.add(createRange(start, end));
                start = end = null;
                i--;
            } else {
                end = nums[i];
            }
        }

        if (start != null) {
            ranges.add(createRange(start, end));
        }

        return ranges;
    }

    private String createRange(int start, int end) {
        StringBuilder range = new StringBuilder().append(start);
        if (start != end) {
            range.append(DELIMITER).append(end);
        }
        return range.toString();
    }

}
