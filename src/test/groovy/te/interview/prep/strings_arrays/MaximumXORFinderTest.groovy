package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class MaximumXORFinderTest extends Specification {

    @Subject MaximumXORFinder.UsingDoubleLoop loopApproach = []
    @Subject MaximumXORFinder.UsingBitsAndHashMap bitAndSetApproach = []

    def "can find maximum XOR of all values in array"(int[] nums, int maximumXOR) {
        expect:
            loopApproach.findMaximumXOR(nums) == maximumXOR
            bitAndSetApproach.findMaximumXOR(nums) == maximumXOR

        where:
            nums                 || maximumXOR
            null                 || 0
            []                   || 0
            [3, 10, 5, 25, 2, 8] || 28
            [1, 2, 3, 4, 9]      || 13
            [8, 10, 2]           || 10
    }

}
