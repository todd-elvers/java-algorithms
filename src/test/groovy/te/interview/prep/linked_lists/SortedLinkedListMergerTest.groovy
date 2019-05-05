package te.interview.prep.linked_lists

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.linked_lists.domain.ListNode


class SortedLinkedListMergerTest extends Specification {

    @Subject
    SortedLinkedListMerger sortedLinkedListMerger = []

    def "can merge k sorted LinkedLists"() {
        given:
            ListNode[] kSortedLists = [
                    ListNode.create(1, 4, 5),
                    ListNode.create(1, 3, 4),
                    ListNode.create(2, 6)
            ]

        expect: 'the k sorted lists to be correctly merged'
            sortedLinkedListMerger.mergeKLists(kSortedLists) == ListNode.create(1, 1, 2, 3, 4, 4, 5, 6)
    }

    def "can handle bogus input"() {
        given:
            ListNode[] nullLists = null
            ListNode[] emptyLists = []
            ListNode[] singleLists = [ListNode.create(1, 2, 3)]

        expect:
            sortedLinkedListMerger.mergeKLists(nullLists) == null
            sortedLinkedListMerger.mergeKLists(emptyLists) == null
            sortedLinkedListMerger.mergeKLists(singleLists) == ListNode.create(1, 2, 3)
    }

}
