package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class SortedArrayMergerTest extends Specification {

    @Subject
    SortedArrayMerger sortedArrayMerger = []

    def "can merge two sorted arrays in O(n+m) time & space"(int[] nums1, int m, int[] nums2, int n, int[] merged) {
        when:
            sortedArrayMerger.merge(nums1, m, nums2, n)

        then:
            nums1 == merged

        where:
            nums1              | m | nums2     | n || merged
            [1, 2, 3, 0, 0, 0] | 3 | [2, 5, 6] | 3 || [1, 2, 2, 3, 5, 6]
    }

}
