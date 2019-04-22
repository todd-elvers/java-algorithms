package te.interview.prep;

/**
 * @see <a href="https://leetcode.com/problems/island-perimeter/">Problem on leetcode</a>
 */
public class IslandPerimeterCounter {
    private static final int LAND = 1;

    public int countPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == LAND) {
                    return countPerimeter(grid, visited, row, column);
                }
            }
        }

        return 0;
    }

    private int countPerimeter(int[][] grid, boolean[][] visited, int row, int column) {
        if (isOutOfBoundsOrWater(grid, row, column)) {
            return 1;
        } else if (visited[row][column]) {
            return 0;
        } else {
            // Multiple squares may share the same water so we only mark land squares to avoid under counting
            visited[row][column] = true;

            // Recursively explore entire island by trying up, down, left, right respectively
            return countPerimeter(grid, visited, row + 1, column)
                    + countPerimeter(grid, visited, row - 1, column)
                    + countPerimeter(grid, visited, row, column - 1)
                    + countPerimeter(grid, visited, row, column + 1);
        }
    }

    private boolean isOutOfBoundsOrWater(int[][] grid, int row, int column) {
        return row < 0
                || row > grid.length - 1
                || column < 0
                || column > grid[row].length - 1
                || grid[row][column] != LAND;
    }

}
