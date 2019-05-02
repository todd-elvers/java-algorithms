package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/house-robber/">Problem on leetcode</a>
 */
public class HouseRobberMaxFinder {

    public int findMax(int[] nums) {
        int currentMax = 0, previousMax = 0;

        for(int num : nums) {
            int temp = currentMax;
            currentMax = Math.max(previousMax + num, currentMax);
            previousMax = temp;
        }

        return currentMax;
    }

}
