package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/missing-element-in-sorted-array/">Problem on
 * leetcode</a>
 */
public class SortedArrayMissingElementFinder {

    /*
        Time : O(n)
        Space: O(1)
     */
    static class UsingBruteForce {
        public int find(int[] nums, int k) {
            if (nums.length == 1) return nums[0] + k;

            int expectedValue = nums[0], missingCount = 0;

            // Walk from 1..n counting the number of missing numbers
            for (int i = 1; i < nums.length; ) {
                if (nums[i] != ++expectedValue) {
                    if (++missingCount == k) return expectedValue;
                } else {
                    i++;
                }
            }

            // If we make it this far then k resides outside of nums so increment
            // expectedValue by the remaining missing numbers to find
            return expectedValue + (k - missingCount);
        }
    }

    /*
        Time : O(log n)
        Space: O(1)
     */
    static class UsingBinarySearch {
        public int find(int[] nums, int k) {
            int n = nums.length;

            // If k is greater than the number of elements that could possibly be missing
            // from nums then decrement k by the amount nums is missing and add it to the
            // last element.
            int countMissingNums = (nums[n - 1] - nums[0]) + 1 - n;
            if (countMissingNums < k) {
                return nums[n - 1] + (k - countMissingNums);
            }

            return binarySearchForKthMissingNumber(nums, k);
        }

        //TODO: Review this and try to figure out how to broadly apply binary search to problems
        private int binarySearchForKthMissingNumber(int[] nums, int k) {
            int low = 0, high = nums.length - 1;

            // We're hunting for which number in nums is (k-missing) away from k-th missing number
            while (low < high - 1) {
                int mid = low + (high - low) / 2;

                int missing = nums[mid] - nums[low] - (mid - low);

                if (missing >= k) {
                    // when the number is larger than k,
                    // then the index won't be located in (mid, high]
                    high = mid;
                } else {
                    // when the number is smaller than k,
                    // then the index won't be located in [low, mid), update k -= missing
                    k -= missing;
                    low = mid;
                }
            }

            return nums[low] + k;
        }

    }

}
