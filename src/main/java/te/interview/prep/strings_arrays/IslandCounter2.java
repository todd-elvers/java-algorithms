package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands-ii/">Problem on leetcode</a>
 */
//TODO: Review this later & try using Union Find
public class IslandCounter2 {

    public List<Integer> count(int m, int n, int[][] positions) {
        if (m <= 0 || n <= 0 || positions.length == 0 || positions[0].length == 0) return new ArrayList<>();

        int[][] grid = new int[m][n];
        int curIslandCount = 0, islandID = 1;
        List<Integer> islandCountByIteration = new ArrayList<>();

        for (int[] position : positions) {
            int adjustment = findIslandCountAdjustment(grid, position[0], position[1], islandID);
            if (adjustment == 1) islandID++;
            islandCountByIteration.add(curIslandCount += adjustment);
        }

        return islandCountByIteration;
    }

    private int findIslandCountAdjustment(int[][] grid, int row, int column, int islandID) {
        if (grid[row][column] != 0) return 0;

        Set<Integer> connectedLandValues = getNeighboringLandValues(grid, row, column);

        if(connectedLandValues.isEmpty()) {
            grid[row][column] = islandID;
            return 1;
        } else if (connectedLandValues.size() == 1) {
            grid[row][column] = connectedLandValues.iterator().next();
            return 0;
        } else {
            grid[row][column] = -1;
            mergeIslands(grid, row, column, connectedLandValues.iterator().next());
            return -(connectedLandValues.size() - 1);
        }
    }

    private Set<Integer> getNeighboringLandValues(int[][] grid, int row, int column) {
        Set<Integer> neighbors = new HashSet<>();

        neighbors.add(getValue(grid, row + 1, column));
        neighbors.add(getValue(grid, row - 1, column));
        neighbors.add(getValue(grid, row, column + 1));
        neighbors.add(getValue(grid, row, column - 1));
        neighbors.remove(0);

        return neighbors;
    }

    private void mergeIslands(int[][] grid, int row, int column, int value) {
        if (getValue(grid, row, column) == 0 || getValue(grid, row, column) == value) return;

        grid[row][column] = value;
        mergeIslands(grid, row + 1, column, value);
        mergeIslands(grid, row - 1, column, value);
        mergeIslands(grid, row, column - 1, value);
        mergeIslands(grid, row, column + 1, value);
    }

    private int getValue(int[][] grid, int row, int column) {
        return row < 0 || row > grid.length - 1 || column < 0 || column > grid[row].length - 1
                ? 0
                : grid[row][column];
    }
}
