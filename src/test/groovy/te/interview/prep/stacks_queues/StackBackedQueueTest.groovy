package te.interview.prep.stacks_queues

import spock.lang.Specification

class StackBackedQueueTest extends Specification {

    def "preserves FIFO ordering"() {
        given:
            StackBackedQueue<String> queue = []

        and:
            queue.add("X")
            queue.add("Y")
            queue.add("Z")

        expect:
            !queue.isEmpty()
            queue.remove() == "X"
            queue.add("XX")
            queue.remove() == "Y"
            queue.remove() == "Z"
            queue.remove() == "XX"
            queue.isEmpty()
    }

}
