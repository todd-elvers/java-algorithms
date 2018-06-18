package te.interview.prep.linked_lists

import spock.lang.Specification
import te.interview.prep.linked_lists.domain.LinkedListNode

class MiddleNodeDeleterTest extends Specification {

    MiddleNodeDeleter middleNodeDeleter = []

    def "can delete a node from a list given only the node" (){
        given:
            def list = LinkedListNode.create(1,2,3,4,5)

        when: 'we remove node w/ value 3'
            def wasDeleted = middleNodeDeleter.delete(list.next.next)

        then:
            wasDeleted

        and:
            list == LinkedListNode.create(1,2,4,5)
    }

    def "gracefully handles bogus input" (){
        when:
            def wasDeleted = middleNodeDeleter.delete(LinkedListNode.create(1))

        then:
            !wasDeleted

        when:
            wasDeleted = middleNodeDeleter.delete(null)

        then:
            !wasDeleted

        and:
            noExceptionThrown()
    }

}
