package te.interview.prep.linked_lists

import spock.lang.Specification
import te.interview.prep.linked_lists.domain.Node

@SuppressWarnings("GroovyPointlessBoolean")
class PalindromeDetectorTest extends Specification {

    PalindromeDetector palindromeDetector = []

    def "can properly identify a palindrome represented by a linked list"() {
        expect:
            palindromeDetector.isPalindrome(linkedList) == expectedResult

        where:
            linkedList                                                 || expectedResult
            Node.create(['r', 'a', 'c', 'e', 'c', 'a', 'r'] as char[]) || true
            Node.create(['r', 'a', 'c', 'e'] as char[])                || false
            Node.create(['a', 'b', 'b', 'a'] as char[])                || true
            Node.create(['a', 'b', 'c'] as char[])                     || false
    }

}
