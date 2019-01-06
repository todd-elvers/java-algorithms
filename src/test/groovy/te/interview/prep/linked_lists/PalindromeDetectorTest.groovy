package te.interview.prep.linked_lists

import spock.lang.Specification
import spock.lang.Unroll
import te.interview.prep.linked_lists.domain.Node

@SuppressWarnings("GroovyPointlessBoolean")
class PalindromeDetectorTest extends Specification {

    @Unroll("given #linkedList we return #expectedResult")
    def "can properly identify a palindrome represented by a linked list"() {
        expect:
            PalindromeDetector.Approach.NAIVE.apply(linkedList) == expectedResult

        and:
            PalindromeDetector.Approach.FAST_SLOW_RUNNER.apply(linkedList) == expectedResult


        where:
            linkedList                                             || expectedResult
            linkedListOfChars(['r', 'a', 'c', 'e', 'c', 'a', 'r']) || true
            linkedListOfChars(['r', 'a', 'c', 'e'])                || false
            linkedListOfChars(['a', 'b', 'b', 'a'])                || true
            linkedListOfChars(['a', 'b', 'b', 'c'])                || false
            linkedListOfChars(['a', 'b', 'c'])                     || false
    }

    private static Node<Character> linkedListOfChars(List chars) {
        return Node.create(chars as char[]) as Node<Character>
    }

}
