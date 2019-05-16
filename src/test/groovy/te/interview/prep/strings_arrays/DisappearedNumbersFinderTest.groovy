package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class DisappearedNumbersFinderTest extends Specification {

    @Subject
    DisappearedNumbersFinder findDisappearedNumbers = []

    def "can find all number that are missing from an array"(int[] nums, List<Integer> missingNumbers) {
        expect:
            findDisappearedNumbers.find(nums) == missingNumbers

        where:
            nums                             || missingNumbers
            [4, 3, 2, 7, 8, 2, 3, 1]         || [5, 6]
            [10, 2, 5, 10, 9, 1, 1, 4, 3, 7] || [6, 8]
    }

}
