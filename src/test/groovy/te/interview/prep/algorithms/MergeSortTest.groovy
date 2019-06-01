package te.interview.prep.algorithms

import spock.lang.Specification

class MergeSortTest extends Specification {

    MergeSort algorithm = []

    def "can sort an unsorted array"(int[] unsorted, int[] sorted) {
        expect:
            algorithm.mergeSort(unsorted) == sorted

        where:
            unsorted                        || sorted
            [3, 1, 2]                       || [1, 2, 3]
            [38, 27, 43, 3, 9, 82, 10]      || [3, 9, 10, 27, 38, 43, 82]
            [2, 10, 9, 8, 6, 7, 5, 4, 3, 1] || [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }


    def "can merge two sorted arrays"(int[] leftSorted, int[] rightSorted, int[] target, int[] bothSorted) {
        expect:
            algorithm.merge(leftSorted, rightSorted, target) == bothSorted

        where:
            leftSorted | rightSorted  | target     || bothSorted
            [1, 2, 3]  | [4, 5, 6, 7] | new int[7] || [1, 2, 3, 4, 5, 6, 7]
            []         | [4, 5, 6, 7] | new int[4] || [4, 5, 6, 7]
            []         | [4]          | new int[1] || [4]
    }

}
