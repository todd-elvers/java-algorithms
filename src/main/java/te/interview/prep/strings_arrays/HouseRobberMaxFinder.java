package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">Problem on leetcode</a>
 */
public class HouseRobberMaxFinder {

    /*
        Time : O(n)
        Space: O(n)
     */
    static class UsingArray {

        /**
         * To use dynamic programming we have to first determine the sub-problems we can break
         * this problem down into.
         *
         * Terminology
         *      f(i) = most we could rob from the first i houses
         *      a[i] = amount of money at the i-th house
         *
         * Sub-problems
         *      case n = 1:
         *          f(1) = a[1]
         *
         *      case n = 2:
         *          f(2) = max(a[1], a[2])
         *
         *      case n = 3:
         *          Either robbing the third house combined with the first house is more:
         *              a[1] + a[3]         which is equivalent to          f(1) + a[3]
         *          Or skipping the first and third and going with the second house is more:
         *              a[2]                which is equivalent to          f(2)
         *          Therefore:
         *              f(3) = max(f(1) + a[3], f(2))
         *
         *      case n = k:
         *          f(i) = max(f(i-2) + a[i], f(i-1))
         */
        public int findMax(int[] amount) {
            if (amount.length == 0) return 0;
            if (amount.length == 1) return amount[0];
            if (amount.length == 2) return Math.max(amount[0], amount[1]);

            int[] max = new int[amount.length];

            // Our formula requires i-2 and i-1 so we eagerly set them up here
            max[0] = amount[0];
            max[1] = Math.max(amount[0], amount[1]);

            for (int i = 2; i < amount.length; i++) {
                max[i] = Math.max(max[i - 2] + amount[i], max[i - 1]);
            }

            return max[amount.length - 1];
        }

    }

    /*
        Time : O(n)
        Space: O(1)
     */
    static class UsingTwoMaxes {

        /**
         * Since all we need from the above explanation is i-2 and i-1 to calculate the max
         * possible to rob at house i, we can represent this calculation in constant space
         * using `maxUpToTwoHousesAgo` for i-2 and `maxUpToOneHousesAgo` for i-1.
         */
        public int findMax(int[] nums) {
            int maxUpToOneHousesAgo = 0, maxUpToTwoHousesAgo = 0;

            for (int num : nums) {
                int temp = maxUpToOneHousesAgo;
                maxUpToOneHousesAgo = Math.max(maxUpToTwoHousesAgo + num, maxUpToOneHousesAgo);
                maxUpToTwoHousesAgo = temp;
            }

            return maxUpToOneHousesAgo;
        }

    }



}
