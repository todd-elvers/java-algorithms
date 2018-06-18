package te.interview.prep.linked_lists

import spock.lang.Specification
import te.interview.prep.linked_lists.domain.LinkedListNode

class NodeDeduplicatorTest extends Specification {

    NodeDeduplicator nodeDeduplicator = []

    def "can deduplicate integer nodes from a linked list"() {
        expect:
            nodeDeduplicator.deduplicate(input)*.data == expectedOutput*.data

        where:
            input                                      || expectedOutput
            LinkedListNode.create(1, 2, 1, 2, 3, 4)    || LinkedListNode.create(1, 2, 3, 4)
            LinkedListNode.create(1, 2, 2, 2, 2, 1, 3) || LinkedListNode.create(1, 2, 3)
    }

}
