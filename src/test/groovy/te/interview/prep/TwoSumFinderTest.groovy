package te.interview.prep

import spock.lang.Specification
import spock.lang.Subject

class TwoSumFinderTest extends Specification {

    @Subject
    TwoSumFinder twoSumFinder = []

    def "can find the two indices whose values summed equal the target sum"() {
        given:
            int[] nums = [2,7,11,15]

        expect:
            twoSumFinder.find(nums, 9) == [0, 1] as int[]
    }

}
