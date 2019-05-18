package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class SummaryRangeFinderTest extends Specification {

    @Subject
    SummaryRangeFinder summaryRangeFinder = []

    def "can find all summary ranges in an array"(int[] nums, List<String> ranges) {
        expect:
            summaryRangeFinder.find(nums) == ranges

        where:
            nums                  || ranges
            null                  || []
            []                    || []
            [0, 1, 2, 4, 5, 7]    || ["0->2", "4->5", "7"]
            [0, 2, 3, 4, 6, 8, 9] || ["0", "2->4", "6", "8->9"]
            [0, 0, 0, 0, 0, 0]    || ["0"]
            [1, 3, 5, 7, 9]       || ["1", "3", "5", "7", "9"]
    }

}
