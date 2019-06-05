package te.interview.prep.algorithms

import spock.lang.Specification
import spock.lang.Subject

class BinarySearchTest extends Specification {

    @Subject
    BinarySearch algorithm = []

    def "can correctly find elements using binary search"(int[] input, int value, int index) {
        expect:
            algorithm.search(input, value) == index

        where:
            input        | value || index
            null         | 2     || -1
            []           | 2     || -1
            [1, 2, 3, 4] | 5     || -1
            [1, 2, 3, 4] | 3     || 2
            [1, 2, 3, 4] | 1     || 0
    }

}
