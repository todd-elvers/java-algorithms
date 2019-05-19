package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands-ii/">Problem on leetcode</a>
 */
//TODO: Review come back to this and use Union Find; my logic doesn't work for one of the edge cases
public class IslandCounter2 {

    public List<Integer> count(int m, int n, int[][] positions) {
        if (m <= 0 || n <= 0 || positions.length == 0 || positions[0].length == 0)
            return new ArrayList<>();

        int[][] grid = new int[m][n];
        int islandCount = 0;
        List<Integer> islandCountByIteration = new ArrayList<>();
        for (int[] position : positions) {
            islandCount += countIslandDifferences(grid, position[0], position[1], islandCount);
            islandCountByIteration.add(islandCount);
        }

        return islandCountByIteration;
    }

    private void getNeighboringLandValues(Set<Integer> connectedLandValues, int[][] grid, int row, int column) {
        if (row + 1 <= grid.length - 1) connectedLandValues.add(grid[row + 1][column]);
        if (row - 1 >= 0) connectedLandValues.add(grid[row - 1][column]);
        if (column + 1 <= grid[row].length - 1) connectedLandValues.add(grid[row][column + 1]);
        if (column - 1 >= 0) connectedLandValues.add(grid[row][column - 1]);

        connectedLandValues.remove(0);
    }

    private int countIslandDifferences(int[][] grid, int row, int column, int islandCounter) {
        if (grid[row][column] != 0) return 0;

        Set<Integer> connectedLandValues = new HashSet<>();
        getNeighboringLandValues(connectedLandValues, grid, row, column);
        if (connectedLandValues.isEmpty()) {
            // If we don't add some uniqueness here we'll fail we may fail to detect
            // the correct number of neighboring land values later on
            grid[row][column] = ++islandCounter;
            return 1;
        } else if (connectedLandValues.size() == 1) {
            grid[row][column] = connectedLandValues.iterator().next();
            return 0;
        } else {
            int minValue = connectedLandValues.stream().min(Integer::compareTo).get();
            grid[row][column] = -1;
            setAllConnectedLands(grid, row, column, minValue);
            return -(connectedLandValues.size() - 1);
        }
    }

    private void setAllConnectedLands(int[][] grid, int row, int column, int value) {
        if (row < 0
                || row > grid.length - 1
                || column < 0
                || column > grid[row].length - 1
                || grid[row][column] == 0
                || grid[row][column] == value) {
            return;
        }

        grid[row][column] = value;

        setAllConnectedLands(grid, row + 1, column, value);
        setAllConnectedLands(grid, row - 1, column, value);
        setAllConnectedLands(grid, row, column - 1, value);
        setAllConnectedLands(grid, row, column + 1, value);
    }

}
