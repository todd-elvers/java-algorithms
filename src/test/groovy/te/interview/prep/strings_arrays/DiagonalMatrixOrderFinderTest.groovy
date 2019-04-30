package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.strings_arrays.DiagonalMatrixOrderFinder

class DiagonalMatrixOrderFinderTest extends Specification {

    @Subject
    DiagonalMatrixOrderFinder diagonalMatrixOrderFinder = []

    def "can traverse a matrix diagonally"(int[][] matrix, int[] result) {
        expect:
            diagonalMatrixOrderFinder.findDiagonalOrder(matrix) == result

        where:
            matrix                            || result
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]] || [1, 2, 4, 7, 5, 3, 6, 8, 9]
            [[1, 2], [4, 5], [7, 8]]          || [1, 2, 4, 7, 5, 8]
    }

}
