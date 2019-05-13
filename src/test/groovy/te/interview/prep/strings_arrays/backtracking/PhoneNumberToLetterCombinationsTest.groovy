package te.interview.prep.strings_arrays.backtracking

import spock.lang.Specification
import spock.lang.Subject

class PhoneNumberToLetterCombinationsTest extends Specification {

    @Subject
    PhoneNumberToLetterCombinations letterCombinations = []

    def "can generate all letter combinations from a number if it were used on a phone"() {
        expect:
            letterCombinations.generateCombinations(digits) == combinations

        where:
            digits || combinations
            null   || []
            ""     || []
            "7"    || ["p", "q", "r", "s"]
            "23"   || ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
            "234"  || ["adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"]
    }

}
