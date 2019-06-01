package te.interview.prep.algorithms_datastructures

import spock.lang.Specification
import spock.lang.Subject

class IntegerBinarySearchTest extends Specification {

    @Subject
    IntegerBinarySearch integerBinarySearch = []

    def "can correctly find elements using binary search"(int[] input, int value, int index) {
        expect:
            integerBinarySearch.search(input, value) == index

        where:
            input        | value || index
            null         | 2     || -1
            []           | 2     || -1
            [1, 2, 3, 4] | 3     || 2
            [1, 2, 3, 4] | 1     || 0
            [1, 2, 3, 4] | 5     || -1
    }

}
