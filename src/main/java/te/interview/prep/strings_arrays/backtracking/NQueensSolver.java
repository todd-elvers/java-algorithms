package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: While this generates the correct answer it is too slow to be a valid solution on leetcode, come back later and try to validate the board as we go instead of at the end.
 *
 * @see <a href="https://leetcode.com/problems/n-queens/">Problem on leetcode</a>
 */
public class NQueensSolver {
    private static final char QUEEN = 'Q';
    private static final char EMPTY_SPACE = '.';

    public List<List<String>> solve(int n) {
        return backtrack(
                new ArrayList<>(),
                new char[n][n],
                n,
                0
        );
    }

    private List<List<String>> backtrack(List<List<String>> allSolutions, char[][] board, int numQueens, int row) {
        if (row == numQueens) {
            if (isValidSolution(board)) {
                allSolutions.add(convertBoardToListOfStrings(board));
            }
        } else {
            Arrays.fill(board[row], EMPTY_SPACE);

            for (int column = 0; column < numQueens; column++) {
                board[row][column] = QUEEN;
                backtrack(allSolutions, board, numQueens, row + 1);
                board[row][column] = EMPTY_SPACE;
            }
        }

        return allSolutions;
    }


    private boolean isValidSolution(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == QUEEN && !isQueenPlacementValid(board, row, column)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Queens can move vertically, horizontally, and diagonally.  Since we always start at the top
     * of the board we only need to check for queens below our current queen.  Since our algorithm
     * only adds one queen to a row at a time, we also do not need to check horizontally. Therefore
     * we only need to check vertically below, diagonally left, and diagonally right of our Queen.
     */
    private boolean isQueenPlacementValid(char[][] board, int row, int column) {
        return isValidVertically(board, row, column)
                && isValidOnLeftDiagonal(board, row, column)
                && isValidOnRightDiagonal(board, row, column);
    }

    private boolean isValidVertically(char[][] board, int row, int column) {
        while (++row <= board.length - 1) {
            if (board[row][column] == QUEEN) return false;
        }

        return true;
    }

    private boolean isValidOnLeftDiagonal(char[][] board, int row, int column) {
        while (++row <= board.length - 1 && --column >= 0) {
            if (board[row][column] == QUEEN) return false;
        }

        return true;
    }

    private boolean isValidOnRightDiagonal(char[][] board, int row, int column) {
        while (++row <= board.length - 1 && ++column <= board[row].length - 1) {
            if (board[row][column] == QUEEN) return false;
        }

        return true;
    }

    private List<String> convertBoardToListOfStrings(char[][] board) {
        return Arrays.stream(board)
                .map(String::new)
                .collect(Collectors.toList());
    }
}
