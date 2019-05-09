package te.interview.prep.strings_arrays;

import java.util.HashMap;

/**
 * @see <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Problem on leetcode</a>
 */
//TODO: Review this: re-create edge cases & re-create solution
public class SubarraySumFinder {

    // Time: O(n^2), Space: O(n)
    static class RecursiveApproach {
        public int countSubarraysThatSumToK(int[] nums, int k) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                count += howManyValuesToTheRightSumToK(nums, k, nums[i], i + 1);
            }

            return count;
        }

        private int howManyValuesToTheRightSumToK(int[] nums, int targetSum, int runningSum, int index) {
            int currentSumCount = (runningSum == targetSum) ? 1 : 0;

            if (index <= nums.length - 1) {
                currentSumCount += howManyValuesToTheRightSumToK(
                        nums,
                        targetSum,
                        runningSum + nums[index],
                        index + 1
                );
            }

            return currentSumCount;
        }
    }

    // Time: O(n), Space: O(n)
    static class HashMapApproach {
        
        public int countSubarraysThatSumToK(int[] nums, int k) {
            int sum = 0, subarraySumsEqualToK = 0;

            HashMap<Integer, Integer> previousSumOccurrences = new HashMap<>();
            // This ensures that if sum-k=0 (i.e. sum == k) that we increment our sum count
            previousSumOccurrences.put(0, 1);

            for(int number : nums) {
                sum += number;

                // If the difference between any previous sum and k is a sum
                // we've already encountered then the sum of the values between
                // that previous sum and the current value we're on is also k.
                // So we increment our count by how many times we've seen the previous sum.
                if(previousSumOccurrences.containsKey(sum - k)) {
                    subarraySumsEqualToK += previousSumOccurrences.get(sum - k);
                }

                int occurrencesOfThisSum = previousSumOccurrences.getOrDefault(sum, 0) + 1;
                previousSumOccurrences.put(sum, occurrencesOfThisSum);
            }

            return subarraySumsEqualToK;
        }
    }


}
