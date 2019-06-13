package te.interview.prep.integers

import spock.lang.Specification
import spock.lang.Subject

class NumberPalindromeCheckerTest extends Specification {

    @Subject
    NumberPalindromeChecker numberPalindromeChecker = []

    def "can determine if a number is a palindrome"() {
        expect:
            numberPalindromeChecker.check(x) == isPalindrome

        where:
            x   || isPalindrome
            0   || true
            1   || true
            -1  || false
            100 || false
            101 || true
    }

}
