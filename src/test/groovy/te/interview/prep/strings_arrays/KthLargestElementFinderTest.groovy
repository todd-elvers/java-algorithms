package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class KthLargestElementFinderTest extends Specification {

    @Subject
    KthLargestElementFinder kthLargestElementFinder = []

    def "can find k-th largest element in a list"(int[] nums, int k, int kthLargest) {
        expect:
            kthLargestElementFinder.find(nums, k) == kthLargest

        where:
            nums                        | k || kthLargest
            [3, 2, 1, 5, 6, 4]          | 2 || 5
            [3, 2, 3, 1, 2, 4, 5, 5, 6] | 4 || 4
    }

}
