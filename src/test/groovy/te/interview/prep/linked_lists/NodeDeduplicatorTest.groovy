package te.interview.prep.linked_lists

import spock.lang.Specification
import te.interview.prep.linked_lists.domain.Node

class NodeDeduplicatorTest extends Specification {

    NodeDeduplicator nodeDeduplicator = []

    def "can deduplicate integer nodes from a linked list"() {
        expect:
            nodeDeduplicator.deduplicate(input)*.data == expectedOutput*.data

        where:
            input                            || expectedOutput
            Node.create(1, 2, 1, 2, 3, 4)    || Node.create(1, 2, 3, 4)
            Node.create(1, 2, 2, 2, 2, 1, 3) || Node.create(1, 2, 3)
    }

}
