package te.interview.prep.linked_lists

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.linked_lists.domain.ListNode

class TwoNumberAdderTest extends Specification {

    @Subject
    TwoNumberAdder.UsingRecursion recursiveApproach = []
    @Subject
    TwoNumberAdder.UsingIteration iterativeApproach = []

    def "can sum two lists of the same size and return as new list"() {
        given: 'a list representing 617 backwards'
            def l1 = ListNode.create(7, 1, 6)

        and: 'a list representing 295 backwards'
            def l2 = ListNode.create(5, 9, 2)

        expect: 'the sum them to be 912 backwards '
            recursiveApproach.add(l1, l2) == ListNode.create(2, 1, 9)
            iterativeApproach.add(l1, l2) == ListNode.create(2, 1, 9)
    }

    def "can sum two lists whose sum is larger in length then either of the inputs"() {
        given: 'a list representing 999 backwards'
            def l1 = ListNode.create(9, 9, 9)

        and: 'a list representing 999 backwards'
            def l2 = ListNode.create(9, 9, 9)

        expect: 'the sum of them to be 1998 backwards'
            recursiveApproach.add(l1, l2) == ListNode.create(8, 9, 9, 1)
            iterativeApproach.add(l1, l2) == ListNode.create(8, 9, 9, 1)
    }

    def "can sum two lists of differing size"() {
        given: 'a list representing 999 backwards'
            def l1 = ListNode.create(9, 9, 9)

        and: 'a list representing 1'
            def l2 = ListNode.create(1)

        expect: 'the sum of them to be 1000 backwards'
            recursiveApproach.add(l1, l2) == ListNode.create(0, 0, 0, 1)
            iterativeApproach.add(l1, l2) == ListNode.create(0, 0, 0, 1)
    }

}
