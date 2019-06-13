package te.interview.prep.linked_lists

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.linked_lists.domain.LinkedListNode

class FindKthToLastElementTest extends Specification {
    @Shared
    def linkedList = LinkedListNode.create(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Subject
    FindKthToLastElement instance = []

    def "can find the kth to last element of a singly linked list"() {
        expect:
            instance.findKthFromLastElement(linkedList, k).data == expectedData

        where:
            k  || expectedData
            3  || 7
            2  || 8
            1  || 9
            0  || 10
            10 || 1
    }

}
