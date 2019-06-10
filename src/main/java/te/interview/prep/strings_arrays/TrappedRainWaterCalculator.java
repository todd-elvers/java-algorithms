package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">Problem on leetcode</a>
 */
public class TrappedRainWaterCalculator {

    /*
        Time : O(n^2)
        Space: O(1)
     */
    static class UsingBruteForce {
        public int calculate(int[] height) {
            int totalWaterTrapped = 0;

            for (int i = 0; i < height.length; i++) {
                int leftMaxHeight = 0;
                for (int j = i; j >= 0; j--) {
                    leftMaxHeight = Math.max(leftMaxHeight, height[j]);
                }
                int rightMaxHeight = 0;
                for (int j = i; j < height.length; j++) {
                    rightMaxHeight = Math.max(rightMaxHeight, height[j]);
                }

                // Water trapped at i = min of the max heights to the left & right, minus i's height
                totalWaterTrapped += Math.min(leftMaxHeight, rightMaxHeight) - height[i];
            }

            return totalWaterTrapped;
        }
    }

    /*
        Time : O(n)
        Space: O(1)
     */
    static class UsingPointers {
        public int calculate(int[] height) {
            int totalWaterTrapped = 0, leftMaxHeight = 0, rightMaxHeight = 0;

            int left = 0, right = height.length - 1;
            while (left < right) {
                // Progress whichever pointer points to the shorter height,
                // either updating the max for that side or the total amount of water trapped.
                if (height[left] < height[right]) {
                    if (height[left] >= leftMaxHeight) {
                        leftMaxHeight = height[left];
                    } else {
                        totalWaterTrapped += leftMaxHeight - height[left];
                    }

                    left++;
                } else {
                    if (height[right] >= rightMaxHeight) {
                        rightMaxHeight = height[right];
                    } else {
                        totalWaterTrapped += rightMaxHeight - height[right];
                    }

                    right--;
                }
            }

            return totalWaterTrapped;
        }
    }


}
