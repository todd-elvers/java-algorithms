package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands-ii/">Problem on leetcode</a>
 */
public class IslandCounter2 {

    //TODO: Complexity Analysis
    static class UsingRecursion {

        public List<Integer> count(int m, int n, int[][] positions) {
            if (m <= 0 || n <= 0 || positions.length == 0 || positions[0].length == 0)
                return new ArrayList<>();

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

            if (connectedLandValues.isEmpty()) {
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

    /*
        Complexity analysis
            Time: O(m*n + positions)
                O(m*n) for disjoint set initialization
                O(positions) to process all the positions
            Space: O(n*m)
                O(n*m) for disjoint set
     */
    static class UsingDisjointSet {
        public List<Integer> count(int m, int n, int[][] positions) {
            if (m <= 0 || n <= 0 || positions.length == 0 || positions[0].length == 0) return Collections.emptyList();

            DisjointSet set = new DisjointSet(m, n);
            List<Integer> islandCounts = new ArrayList<>();

            for (int[] position : positions) {
                int row = position[0], column = position[1];

                set.addLand(row, column);

                if (set.isLand(row - 1, column)) set.union(row, column, row - 1, column);
                if (set.isLand(row + 1, column)) set.union(row, column, row + 1, column);
                if (set.isLand(row, column - 1)) set.union(row, column, row, column - 1);
                if (set.isLand(row, column + 1)) set.union(row, column, row, column + 1);

                islandCounts.add(set.setCount);
            }

            return islandCounts;
        }

        private static class DisjointSet {
            private int rows, columns, setCount;
            private int[] parents;
            private int[] rank;

            DisjointSet(int rows, int columns) {
                this.setCount = 0;
                this.rows = rows;
                this.columns = columns;
                this.parents = new int[rows * columns];
                this.rank = new int[rows * columns];
                Arrays.fill(parents, -1);   // Init all parents to -1 since 0 != 'not set'
            }

            boolean isLand(int row, int column) {
                if (column < 0 || column > columns - 1 || row < 0 || row > rows - 1) return false;
                return parents[toIndex(row, column)] != -1;
            }

            void addLand(int row, int column) {
                int index = toIndex(row, column);
                if (parents[index] != index) {
                    parents[index] = index;
                    setCount++;
                }
            }

            private int toIndex(int row, int column) {
                return (row * columns) + column;
            }

            private int find(int x) {
                if (x != parents[x]) parents[x] = find(parents[x]);     // Path compression
                return parents[x];
            }

            void union(int xRow, int xColumn, int yRow, int yColumn) {
                int xSet = find(toIndex(xRow, xColumn)), ySet = find(toIndex(yRow, yColumn));
                if (xSet == ySet) return;
                unionByRank(xSet, ySet);
                setCount--;
            }

            private void unionByRank(int xSet, int ySet) {
                if (rank[xSet] < rank[ySet]) {
                    parents[xSet] = ySet;
                } else {
                    parents[ySet] = xSet;
                    if (rank[xSet] == rank[ySet]) {
                        rank[ySet]++;
                    }
                }
            }
        }
    }
}