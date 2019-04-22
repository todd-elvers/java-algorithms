package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject

class AddOneToDigitsTest extends Specification {

    @Subject
    AddOneToDigits addOneToDigits = []

    def "can add one to an array of digits that represent a number"(int[] input, int[] output) {
        expect:
            addOneToDigits.addOneTo(input) == output

        where:
            input        || output
            [1, 2, 3]    || [1, 2, 4]
            [4, 3, 2, 1] || [4, 3, 2, 2]
            [9, 9, 9]    || [1, 0, 0, 0]
    }

}
