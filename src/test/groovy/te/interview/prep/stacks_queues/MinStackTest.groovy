package te.interview.prep.stacks_queues

import spock.lang.Specification
import te.interview.prep.stacks_queues.MinStack

class MinStackTest extends Specification {

    MinStack stack = []

    def "min() returns the minimum value from the stack"() {
        given:
            Integer five = 5
            Integer ten = 10
            Integer fifteen = 15
            Integer twenty = 20

        when: 'we call min() on an empty stack'
            stack.min()

        then:
            thrown(EmptyStackException)

        when:
            stack.push(fifteen)

        then:
            stack.min() == fifteen

        when:
            stack.push(ten)

        then:
            stack.min() == ten

        when:
            stack.push(five)

        then:
            stack.min() == five

        when:
            stack.push(fifteen)

        then:
            stack.min() == five

        when: 'we pop all the way back down to the first element'
            stack.pop()
            stack.pop()
            stack.pop()

        then: 'the minimum value is kept up to date'
            stack.min() == fifteen

        when: 'we add another value'
            stack.push(twenty)

        then: 'our minimum value is still correct'
            stack.min() == fifteen
    }

}
