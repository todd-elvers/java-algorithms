package te.interview.prep.linked_lists

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.linked_lists.domain.ListNode

class NthFromEndRemoverTest extends Specification {

    @Subject
    NthFromEndRemover nthFromEndRemover = []

    def "can remove nth node from end of a linked list"() {
        expect:
            nthFromEndRemover.removeNthFromEnd(list, n) == result

        where:
            list                           | n || result
            ListNode.create(1, 2, 3, 4, 5) | 2 || ListNode.create(1, 2, 3, 5)
            ListNode.create(1, 2, 3, 4, 5) | 1 || ListNode.create(1, 2, 3, 4)
            ListNode.create(1)             | 1 || null
            ListNode.create(1, 2)          | 2 || ListNode.create(2)
    }

}
