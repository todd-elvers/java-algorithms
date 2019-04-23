package te.interview.prep;

/**
 * @see <a href="https://leetcode.com/problems/two-sum/">Problem on leetcode</a>
 */
public class TwoSumFinder {

    public int[] find(int[] nums, int target) {
        if(nums == null || nums.length == 0) return nums;

        for(int i = 0; i < nums.length; i++) {
            int secondIndex = findIndexForTargetSum(nums, target, i, i + 1);
            if(secondIndex != -1) {
                return new int[] { i, secondIndex };
            }
        }

        return null;
    }

    private int findIndexForTargetSum(int[] nums, int targetSum, int firstIndex, int start) {
        for (int i = start; i < nums.length; i++) {
            if(nums[firstIndex] + nums[i] == targetSum) return i;
        }

        return -1;
    }

}
