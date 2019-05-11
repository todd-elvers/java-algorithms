package te.interview.prep.strings_arrays

import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Subject

class PhoneNumberToLetterCombinationsTest extends Specification {

    @Subject
    PhoneNumberToLetterCombinations letterCombinations = []

    @NotYetImplemented
    def "can generate all letter combinations from a number if it were used on a phone"() {
        expect:
            letterCombinations.generateCombinations(digits) == combinations

        where:
            digits || combinations
            "23"   || ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }

}
