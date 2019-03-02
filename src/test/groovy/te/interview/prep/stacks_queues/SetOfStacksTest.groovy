package te.interview.prep.stacks_queues


import spock.lang.Specification

class SetOfStacksTest extends Specification {

    def "pop() on an empty stack causes EmptyStackException"() {
        when:
            new SetOfStacks<>(3).pop()

        then:
            thrown(EmptyStackException)
    }

    def "honors LIFO ordering and maintains correct number of stacks"() {
        when:
            SetOfStacks<Integer> stack = [2]

        then:
            stack.getNumStacks() == 0

        when:
            stack.push(1)
            stack.push(2)
            stack.push(3)
            stack.push(4)

        then:
            stack.getNumStacks() == 2
            stack.pop() == 4
            stack.pop() == 3
            stack.getNumStacks() == 1
            stack.pop() == 2
            stack.pop() == 1
            stack.getNumStacks() == 0
    }

    def "popAt() pops from the correct stack and cleans up after itself"() {
        given: 'a SetOfStacks like [[1,2], [3,4], [5,6]]'
            SetOfStacks<Integer> stack = [2]
            stack.push(1)   // 2
            stack.push(2)   // 2
            stack.push(3)   // 1
            stack.push(4)   // 1
            stack.push(5)   // 0
            stack.push(6)   // 0

        expect:
            stack.getNumStacks() == 3
            stack.popAt(0) == 6
            stack.popAt(1) == 4
            stack.popAt(2) == 2
            stack.getNumStacks() == 3
            stack.popAt(0) == 5
            stack.getNumStacks() == 2
            stack.popAt(0) == 3
            stack.getNumStacks() == 1
            stack.popAt(0) == 1
            stack.isEmpty()
    }

    def "popAt() correctly handles boundary conditions"() {
        when:
            new SetOfStacks<Integer>(1).popAt(0)

        then:
            thrown(EmptyStackException)

        when:
            SetOfStacks<Integer> stacks = [2]
            stacks.push(1)
            stacks.push(2)
            stacks.push(3)
            stacks.push(4)
            stacks.popAt(2)

        then:
            thrown(IndexOutOfBoundsException)
    }

}
