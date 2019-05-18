package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class Sorted2DArraySearcherTest extends Specification {

    @Subject
    Sorted2DArraySearcher sorted2DArraySearcher = []

    def "can determine if a sorted 2D array contains a value"(int[][] matrix, int value, boolean containsValue) {
        expect:
            sorted2DArraySearcher.search(matrix, value) == containsValue

        where:
            matrix << [
                    [
                            [1, 4, 7, 11, 15],
                            [2, 5, 8, 12, 19],
                            [3, 6, 9, 16, 22],
                            [10, 13, 14, 17, 24],
                            [18, 21, 23, 26, 30],
                    ],
                    [
                            [1, 4, 7, 11, 15],
                            [2, 5, 8, 12, 19],
                            [3, 6, 9, 16, 22],
                            [10, 13, 14, 17, 24],
                            [18, 21, 23, 26, 30]
                    ],
                    [],
                    null
            ]

            value << [
                    5,
                    20,
                    20,
                    20
            ]

            containsValue << [
                    true,
                    false,
                    false,
                    false
            ]
    }

}
