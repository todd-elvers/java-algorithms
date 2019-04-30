package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class SubarraySumFinderTest extends Specification {

    @Subject
    SubarraySumFinder subarraySumFinder = []

    @NotYetImplemented
    def "can find the number of continuous subarrays that sum to a given value"(int[] nums, int k, int result) {
        expect:
            subarraySumFinder.countSubarraysThatSumToK(nums, k) == result

        where:
            nums      | k || result
            [1, 1, 1] | 2 || 2
    }

}
