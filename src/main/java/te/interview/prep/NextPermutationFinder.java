package te.interview.prep;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/next-permutation/">Problem on leetcode</a>
 */
public class NextPermutationFinder {

    public void findNext(int[] nums) {
        if (nums == null || nums.length == 1) return;

        int firstDecreasingIndex = findFirstDecreasingElementInReverse(nums);
        if (firstDecreasingIndex != -1) {
            swap(nums, firstDecreasingIndex, findElementClosestInValueToFirstDecreasing(nums, firstDecreasingIndex));
        }

        Arrays.sort(nums, firstDecreasingIndex + 1, nums.length);
    }

    protected int findFirstDecreasingElementInReverse(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    protected int findElementClosestInValueToFirstDecreasing(int[] nums, int targetElement) {
        for (int i = targetElement + 1; i < nums.length; i++) {
            if (nums[i] <= nums[targetElement]) {
                // Current element is <= our element so the previous value is the closest
                return i - 1;
            }
        }

        return nums.length - 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // This is no longer used but is being kept for educational purposes
    protected void reverse(int[] nums, int start) {
        for (int end = nums.length - 1; start < end; start++, end--) {
            swap(nums, start, end);
        }
    }
}
