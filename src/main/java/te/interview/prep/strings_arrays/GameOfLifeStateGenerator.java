package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/game-of-life/">Problem on leetcode</a>
 */
public class GameOfLifeStateGenerator {

    // Time: O(n+m) Space: O(n+m)
    // Trick: don't update state while processing grid, find all state changes & apply them at once
    public void generateNextState(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return;

        List<int[]> stateChanges = new ArrayList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int livingNeighbors = countLivingNeighbors(grid, row, column);
                int currentState = grid[row][column];
                int newState = applyRulesForLife(currentState, livingNeighbors);

                if(newState != currentState) {
                    stateChanges.add(new int[] { row, column, newState });
                }
            }
        }

        for(int[] rowColumnAndNewState : stateChanges) {
            grid[rowColumnAndNewState[0]][rowColumnAndNewState[1]] = rowColumnAndNewState[2];
        }
    }

    // Cells have eight possible neighbors
    private int countLivingNeighbors(int[][] grid, int row, int column) {
        return countIfAlive(grid, row - 1, column)              // Up
                + countIfAlive(grid, row - 1, column + 1)       // Up-Right
                + countIfAlive(grid, row, column + 1)           // Right
                + countIfAlive(grid, row + 1, column + 1)       // Down-Right
                + countIfAlive(grid, row + 1, column)           // Down
                + countIfAlive(grid, row + 1, column - 1)       // Down-Left
                + countIfAlive(grid, row, column - 1)           // Left
                + countIfAlive(grid, row - 1, column - 1);      // Up-Left
    }

    // Cells are alive if they're on the board and equal to 1
    private int countIfAlive(int[][] grid, int row, int column) {
        return row < 0
                || row > grid.length - 1
                || column < 0
                || column > grid[row].length - 1
                || grid[row][column] == 0
                ? 0
                : 1;
    }

    private int applyRulesForLife(int cellValue, int livingNeighbors) {
        if (cellValue == 1) {
            if (livingNeighbors < 2) return 0;
            if (livingNeighbors == 2 || livingNeighbors == 3) return 1;
        } else {
            if (livingNeighbors == 3) return 1;
        }

        return 0;
    }
}
