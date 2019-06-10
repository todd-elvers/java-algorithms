package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class MissingNumberFinderTest extends Specification {

    @Subject
    MissingNumberFinder.UsingHashSet setApproach = []

    @Subject
    MissingNumberFinder.UsingGaussFormula gaussApproach = []

    def "can find the number missing from an array of n distinct numbers"(int[] nums, int missingNumber) {
        expect:
            setApproach.find(nums) == missingNumber
            gaussApproach.find(nums) == missingNumber

        where:
            nums                        || missingNumber
            [3, 0, 1]                   || 2
            [9, 6, 4, 2, 3, 5, 7, 0, 1] || 8
    }

}
