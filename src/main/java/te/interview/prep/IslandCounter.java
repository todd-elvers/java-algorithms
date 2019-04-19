package te.interview.prep;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands/submissions/">Problem on
 * leetcode</a>
 */
public class IslandCounter {
    private static final char LAND = '1';

    public int count(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int islands = 0;
        boolean[][] visitedLands = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == LAND && !visitedLands[row][column]) {
                    islands++;
                    visitEntireIsland(grid, visitedLands, row, column);
                }
            }
        }

        return islands;
    }

    private void visitEntireIsland(char[][] grid, boolean[][] visitedLands, int row, int column) {
        boolean isBaseCase =
                row < 0                         // Top edge
                || row > grid.length - 1        // Bottom edge
                || column < 0                   // Left edge
                || column > grid[0].length - 1  // Right edge
                || visitedLands[row][column]    // Already visited
                || grid[row][column] != LAND;   // Water

        if (isBaseCase) return;

        visitedLands[row][column] = true;
        visitEntireIsland(grid, visitedLands, row + 1, column);
        visitEntireIsland(grid, visitedLands, row - 1, column);
        visitEntireIsland(grid, visitedLands, row, column + 1);
        visitEntireIsland(grid, visitedLands, row, column - 1);
    }

}
