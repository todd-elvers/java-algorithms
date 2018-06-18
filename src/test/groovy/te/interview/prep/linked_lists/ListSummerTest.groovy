package te.interview.prep.linked_lists

import spock.lang.Specification
import te.interview.prep.linked_lists.domain.LinkedListNode

class ListSummerTest extends Specification {

    ListSummer listSummer = []

    def "can sum two lists of the same size and return as new list"() {
        given: 'a list representing 617 backwards'
            def l1 = LinkedListNode.create(7,1,6)

        and: 'a list representing 295 backwards'
            def l2 = LinkedListNode.create(5,9,2)

        when: 'we sum these lists'
            def result = listSummer.sum(l1,l2,0)

        then: 'we get 912 backwards'
            result == LinkedListNode.create(2,1,9)
    }

    def "can sum two lists of the same size and return as new list, even for edge cases"() {
        given: 'a list representing 879 backwards'
            def l1 = LinkedListNode.create(9,7,8)

        and: 'a list representing 586 backwards'
            def l2 = LinkedListNode.create(6,8,5)

        when: 'we sum these lists'
            def result = listSummer.sum(l1,l2,0)

        then: 'we get 1465 backwards'
            result == LinkedListNode.create(5,6,4,1)
    }

    def "can sum two lists of differing size"() {
        given: 'a list representing 1617 backwards'
            def l1 = LinkedListNode.create(7,1,6,1)

        and: 'a list representing 295 backwards'
            def l2 = LinkedListNode.create(5,9,2)

        when: 'we sum these lists'
            def result = listSummer.sum(l1,l2,0)

        then: 'we get 1912 backwards'
            result == LinkedListNode.create(2,1,9,1)
    }

}
