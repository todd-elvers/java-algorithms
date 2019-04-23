package te.interview.prep.linked_lists

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.linked_lists.domain.ListNode

class SortedListMergerTest extends Specification {

    @Subject
    SortedListMerger sortedListMerger = []

    def "can merge two sorted linked lists in the correct order"() {
        given:
            ListNode l1 = ListNode.create(1, 2, 4)
            ListNode l2 = ListNode.create(1, 3, 4, 5)

        expect:
            sortedListMerger.merge(l1, l2) == ListNode.create(1, 1, 2, 3, 4, 4, 5)
    }

}
