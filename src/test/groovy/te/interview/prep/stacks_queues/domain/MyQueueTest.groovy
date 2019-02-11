package te.interview.prep.stacks_queues.domain

import spock.lang.Specification

class MyQueueTest extends Specification {

    def "preserves FIFO ordering"() {
        given:
            MyQueue<String> queue = new MyQueue<String>()

        and:
            queue.add("X")
            queue.add("Y")
            queue.add("Z")

        expect:
            !queue.isEmpty()
            queue.remove() == "X"
            queue.remove() == "Y"
            queue.remove() == "Z"
            queue.isEmpty()
    }

}
