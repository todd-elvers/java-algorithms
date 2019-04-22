package te.interview.prep.stacks_queues

import spock.lang.Specification
import spock.lang.Subject

class MaxStackTest extends Specification {

    @Subject
    MaxStack maxStack = []

    def "can determine the max value on the stack and pop it, even when it is not on top"() {
        given:
            maxStack.push(9)
            maxStack.push(7)
            maxStack.push(10)
            maxStack.push(6)
            maxStack.push(4)
            maxStack.push(2)

        expect: 'the max value in the stack is 10'
            maxStack.peekMax() == 10

        and: 'the other operations also work'
            maxStack.pop() == 2
            maxStack.push(2)
            maxStack.top() == 2

        when: 'we pop the max'
            int max = maxStack.popMax()

        then: 'the popped value is correct'
            max == 10

        and: 'the max value was correctly updated to be 9 (which is at the bottom of the stack)'
            maxStack.peekMax() == 9
    }

}
