package te.interview.prep.algorithms

import spock.lang.Specification

class QuickSortTest extends Specification {

    QuickSort algorithm = []

    def "can sort an unsorted array"(int[] unsorted, int[] sorted) {
        expect:
            algorithm.quickSort(unsorted) == sorted

        where:
            unsorted                        || sorted
            [3, 1, 2]                       || [1, 2, 3]
            [38, 27, 43, 3, 9, 82, 10]      || [3, 9, 10, 27, 38, 43, 82]
            [2, 10, 9, 8, 6, 7, 5, 4, 3, 1] || [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }

    def "can swap elements in an array"(int[] array, int index1, int index2, int[] swappedArray) {
        when:
            algorithm.swap(array, index1, index2)

        then:
            array == swappedArray

        where:
            array        | index1 | index2 || swappedArray
            [1, 2, 3, 4] | 0      | 1      || [2, 1, 3, 4]
            [1, 2, 3, 4] | 1      | 2      || [1, 3, 2, 4]
            [1, 2, 3, 4] | 2      | 3      || [1, 2, 4, 3]
    }

}
