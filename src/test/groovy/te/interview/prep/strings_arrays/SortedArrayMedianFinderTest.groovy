package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class SortedArrayMedianFinderTest extends Specification {

    @Subject
    SortedArrayMedianFinder sortedArrayMedianFinder = []

    def "can find the median of two sorted arrays"(int[] nums1, int[] nums2, double median) {
        expect:
            sortedArrayMedianFinder.find(nums1, nums2) == median

        where:
            nums1                 | nums2    || median
            [1, 3]                | [2]      || 2.0
            [1, 2, 3]             | []       || 2.0
            [1, 2, 4]             | [3]      || 2.5
            [1, 2, 3]             | [4]      || 2.5
            [1, 2, 3, 4, 6, 7, 8] | [5]      || 4.5
            [3]                   | [-2, -1] || -1.0
    }

}
