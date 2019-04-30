package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class SpiralMatrixTraverserTest extends Specification {

    @Subject
    SpiralMatrixTraverser spiralMatrixTraverser = []

    @NotYetImplemented
    def "can traverse a matrix in spiral order"(int[][] matrix, List<Integer> spiralOrder) {
        expect:
            spiralMatrixTraverser.traverse(matrix) == spiralOrder

        where:
            matrix                                        || spiralOrder
            [[1, 2, 3], [4, 5, 6], [7, 8, 9]]             || [1, 2, 3, 6, 9, 8, 7, 4, 5]
            [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]] || [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }

}
