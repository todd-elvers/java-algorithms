package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class DiagonalMatrixTraverserTest extends Specification {

    @Subject
    DiagonalMatrixTraverser diagonalMatrixTraverser = []

    def "can traverse a matrix diagonally"(int[][] matrix, int[] result) {
        expect:
            diagonalMatrixTraverser.traverse(matrix) == result

        where:
            matrix                            || result
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]] || [1, 2, 4, 7, 5, 3, 6, 8, 9]
            [[1, 2], [4, 5], [7, 8]]          || [1, 2, 4, 7, 5, 8]
    }

}
