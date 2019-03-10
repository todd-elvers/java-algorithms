package te.interview.prep.trees_graphs

import spock.lang.Specification

class LinkedListWeaverTest extends Specification {

    LinkedListWeaver linkedListWeaver = []

    def "can weave two arrays together"() {
        when:
            List<LinkedList<Integer>> result = linkedListWeaver.weave(
                    linkedList(1,2),
                    linkedList(3,4)
            )

        then:
            result?.size() == 6
            result.contains(linkedList(1,2,3,4))
            result.contains(linkedList(1,3,2,4))
            result.contains(linkedList(1,3,4,2))
            result.contains(linkedList(3,1,2,4))
            result.contains(linkedList(3,1,4,2))
            result.contains(linkedList(3,4,1,2))
    }

    private static LinkedList<Integer> linkedList(int... integers) {
        LinkedList<Integer> linkedList = new LinkedList<>()
        integers.each { linkedList.add(it) }
        return linkedList
    }

}
