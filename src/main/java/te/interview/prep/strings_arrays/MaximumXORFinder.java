package te.interview.prep.strings_arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/">Problem on
 * leetcode</a>
 */
// TODO: Review this and see if I can come up with the bit-manipulation solution on my own
public class MaximumXORFinder {

    // Time: O(n^2), Space: O(1)
    static class UsingDoubleLoop {

        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    max = Math.max(max, nums[i] ^ nums[j]);
                }
            }

            return max;
        }

    }

    // Time: O(n), Space: O(n)
    static class UsingBitsAndHashMap {

        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int max = 0, mask = 0;
            for (int i = 31; i >= 0; i--) {
                // Set the i-th bit of the previous mask to 1
                mask |= (1 << i);

                // Switch the i-th bit of our current max to 1
                int potentialMax = max | (1 << i);

                Set<Integer> maskedValues = new HashSet<>();
                for (int n : nums) {
                    // Construct a new value out of the bits that both `n` and `mask` have set
                    int bitsInCommon = n & mask;

                    // Construct a new value out of the bits that `potentialMax` has set that `num` does not.
                    int differenceInBits = potentialMax ^ bitsInCommon;

                    // If (A ^ B = C) then (A ^ C  = B) and (B ^ C = A)
                    // Here (B = n & mask) and (C = max | (1 << i)).
                    // We already know that B is in the set because we added it in previous iterations
                    // of this loop, so we now must check if A exists in the set by checking for (B ^ C).
                    if (maskedValues.contains(differenceInBits)) {
                        // Put another way:
                        // If we have a masked value that is comprised of the bits missing between (n & mask)
                        // and `potentialMax` then we could XOR some nums[i] and some nums[j] to get `potentialMax`.
                        // Therefore we have found a new maximum XOR value.
                        max = potentialMax;
                        break;
                    }

                    // Store the bits `n` and `mask` have in common for future iterations
                    maskedValues.add(bitsInCommon);
                }
            }

            return max;
        }

    }

}
