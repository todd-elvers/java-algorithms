package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class ThreeSumFinderTest extends Specification {

    @Subject
    ThreeSumFinder threeSumFinder = []

    def "can find all unique triplets in an array tha sum to zero"(int[] nums, List<List<Integer>> triplets) {
        expect:
            threeSumFinder.find(nums) == triplets

        where:
            nums                  || triplets
            [-1, 0, 1, 2, -1, -4] || [[-1, -1, 2], [-1, 0, 1]]
    }

}
