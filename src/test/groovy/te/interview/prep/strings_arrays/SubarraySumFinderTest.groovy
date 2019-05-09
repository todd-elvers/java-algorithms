package te.interview.prep.strings_arrays


import spock.lang.Specification
import spock.lang.Subject

class SubarraySumFinderTest extends Specification {

    @Subject
    SubarraySumFinder.RecursiveApproach recursiveSubarraySumFinder = []

    @Subject
    SubarraySumFinder.HashMapApproach hashMapSubarraySumFinder = []

    def "can find the number of continuous subarrays that sum to a given value"(int[] nums, int k, int result) {
        expect:
            recursiveSubarraySumFinder.countSubarraysThatSumToK(nums, k) == result
            hashMapSubarraySumFinder.countSubarraysThatSumToK(nums, k) == result

        where:
            nums                     | k || result
            [0, 0, 0]                | 0 || 6
            [1, 1, 1]                | 2 || 2
            []                       | 0 || 0
            [3, 4, 7, -1, -3, 4, -1] | 7 || 4
    }

}
