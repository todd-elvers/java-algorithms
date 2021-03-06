package te.interview.prep.strings_arrays;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/missing-number/">Problem on leetcode</a>
 */
public class MissingNumberFinder {

    /*
        Time : O(n)
        Space: O(n)
     */
    static class UsingHashSet {

        public int find(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);

            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }

            return -1;
        }

    }

    /*
        Time : O(n)
        Space: O(1)
     */
    static class UsingGaussFormula {

        public int find(int[] nums) {
            return sumOfZeroToN(nums.length) - sum(nums);
        }

        private int sumOfZeroToN(int n) {
            return (n * (n + 1)) / 2;
        }

        private int sum(int[] nums) {
            int sumOfNums = 0;
            for (int num : nums) sumOfNums += num;
            return sumOfNums;
        }
    }

    /*
        Time : O(n)
        Space: O(1)
     */
    static class UsingXOR {

        // By relying on the fact that XOR will return us the bits that are set in one
        // value and not set in another, and that our missing value is between 0 and n,
        // we can initialize our missing number to n and then remove all the bits set
        // by all the numbers present in nums to get our missing number.
        public int find(int[] nums) {
            int missingNumber = nums.length;

            for(int i = 0; i < nums.length; i++) {
                missingNumber ^= i ^ nums[i];
            }

            return missingNumber;
        }
    }
}
