package te.interview.prep.stacks_queues

import spock.lang.Specification

class BasicStackTest extends Specification {

    BasicStack<Integer> stack = []

    def "pop() on an empty stack causes EmptyStackException"() {
        when:
            stack.pop()

        then:
            thrown(EmptyStackException)
    }

    def "honors LIFO ordering"() {
        when:
            stack.push(1)
            stack.push(2)
            stack.push(3)
            stack.push(4)

        then:
            stack.pop() == 4
            stack.pop() == 3
            stack.pop() == 2
            stack.pop() == 1
    }

}
