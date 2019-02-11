package te.interview.prep.stacks_queues

import spock.lang.Specification
import te.interview.prep.stacks_queues.BasicQueue

class BasicQueueTest extends Specification {

    def "preserves FIFO ordering"() {
        given:
            BasicQueue<String> queue = new BasicQueue<String>()

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
