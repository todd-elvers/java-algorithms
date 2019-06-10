package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/paint-house/">Problem on leetcode</a>
 */
public class MinimumCostHousePaintFinder {

    public int find(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        // Every iteration through the loop we calculate the minimum it costs to paint the
        // current house red/blue/green had we painted the previous house either of the
        // other two colors. Once we've processed all houses one of the three minimums
        // will be the minimum cost to paint all houses without painting any two adjacent
        // houses the same color.
        int redCost = 0, blueCost = 0, greenCost = 0;
        for (int[] cost : costs) {
            int prevRedCost = redCost, prevBlueCost = blueCost, prevGreenCost = greenCost;

            redCost = cost[0] + Math.min(prevBlueCost, prevGreenCost);
            blueCost = cost[1] + Math.min(prevRedCost, prevGreenCost);
            greenCost = cost[2] + Math.min(prevRedCost, prevBlueCost);
        }

        return Math.min(redCost, Math.min(blueCost, greenCost));
    }

}
