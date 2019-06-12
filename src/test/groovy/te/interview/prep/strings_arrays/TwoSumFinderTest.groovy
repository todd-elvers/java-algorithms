package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class TwoSumFinderTest extends Specification {

    @Subject
    TwoSumFinder.UsingBruteForce bruteForceApproach = []
    @Subject
    TwoSumFinder.UsingHashMap hashMapApproach = []

    def "can find the two indices whose values summed equal the target sum"(int[] nums, int target, int[] result) {
        expect:
            bruteForceApproach.find(nums, target) == result
            hashMapApproach.find(nums, target) == result

        where:
            nums            | target || result
            [2, 11, 7, 15]  | 9      || [0, 2]
            [-2, 11, 7, 15] | 9      || [0, 1]
            [15, 11, -2, 7] | 9      || [1, 2]
            [5, 1, 3, 2, 4] | 9      || [0, 4]
    }

}