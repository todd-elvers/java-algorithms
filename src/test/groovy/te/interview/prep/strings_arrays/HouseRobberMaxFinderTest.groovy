package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class HouseRobberMaxFinderTest extends Specification {

    @Subject
    HouseRobberMaxFinder houseRobberMaxFinder = []

    def "can determine the correct max where now two used values are adjacent"(int[] nums, int max) {
        expect:
            houseRobberMaxFinder.findMax(nums) == max

        where:
            nums            || max
            [1, 2, 3, 1]    || 4
            [2, 7, 9, 3, 1] || 12
            [1, 7, 2, 9, 8] || 16
    }

}
