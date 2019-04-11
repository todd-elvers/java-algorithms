package te.interview.prep.linked_lists

import spock.lang.Specification
import te.interview.prep.linked_lists.domain.LoopNode

class LinkedListLoopFinderTest extends Specification {

    LinkedListLoopFinder.HashMapApproach hashMapApproach = []
    LinkedListLoopFinder.FastSlowRunnerApproach fastSlowRunnerApproach = []

    Optional<LoopNode<String>> result

    def "can properly handle lists with no nodes"() {
        expect:
            !hashMapApproach.findLoop(null).isPresent()
            !fastSlowRunnerApproach.findLoop(null).isPresent()
    }

    def "can properly handle lists with only one node"() {
        given:
            LoopNode<String> list = LoopNode.create("A")

        expect:
            !hashMapApproach.findLoop(list).isPresent()
            !fastSlowRunnerApproach.findLoop(list).isPresent()
    }

    def "can properly handle lists with no loop"() {
        given:
            LoopNode<String> list = LoopNode.create("A", "B", "C", "D")

        expect:
            !hashMapApproach.findLoop(list).isPresent()
            !fastSlowRunnerApproach.findLoop(list).isPresent()
    }

    def "can properly handle lists with loops"() {
        given:
            LoopNode<String> list = LoopNode.create("A", "B", "C", "D", "E")
            LoopNode<String> nodeLoopBeginsOn = findFirstMatchingNodeInList(list, "C")
            LoopNode<String> listWithLoop = appendToEndOfList(list, nodeLoopBeginsOn)

        when:
            result = hashMapApproach.findLoop(listWithLoop)

        then: 'we find a node that has the expected data'
            result.isPresent()
            result.get().data == nodeLoopBeginsOn.data

        and: 'that node references the expected space in memory'
            result.get().is(nodeLoopBeginsOn)

        when:
            result = fastSlowRunnerApproach.findLoop(listWithLoop)

        then: 'we find a node that has the expected data'
            result.isPresent()
            result.get().data == nodeLoopBeginsOn.data

        and: 'that node references the expected space in memory'
            result.get().is(nodeLoopBeginsOn)
    }

    def "can properly handle lists with nodes that have duplicate data"() {
        given:
            LoopNode<String> list = LoopNode.create("A", "B", "B", "C", "C", "D", "D", "E", "E", "F")
            LoopNode<String> nodeLoopBeginsOn = findFirstMatchingNodeInList(list, "D")
            LoopNode<String> listWithLoop = appendToEndOfList(list, nodeLoopBeginsOn)

        when:
            result = hashMapApproach.findLoop(listWithLoop)

        then: 'we find a node that has the expected data'
            result.isPresent()
            result.get().data == nodeLoopBeginsOn.data

        and: 'that node references the expected space in memory'
            result.get().is(nodeLoopBeginsOn)
    }

    private static LoopNode<String> appendToEndOfList(LoopNode<String> head, LoopNode<String> nodeToLoopBackTo) {
        LoopNode<String> n = head
        while(n.next != null) {
            n = n.next
        }

        n.next = nodeToLoopBackTo

        return head
    }

    private static LoopNode<String> findFirstMatchingNodeInList(LoopNode<String> list, String data) {
        LoopNode<String> n = list
        while(n.next != null) {
            if(n.data == data) {
                return n
            }

            n = n.next
        }

        throw new RuntimeException("Could not find a node in the LinkedList with data '$data'.")
    }
}
