package te.interview.prep.stacks_queues

import spock.lang.Specification

class StackSorterTest extends Specification {

    StackSorter stackSorter = []

    def "sorts a stack into ascending order"() {
        given:
            BasicStack<Integer> unsortedStack = new BasicStack<>()
            unsortedStack.pushAll(10, 1, 4, 2, 3, 6, 9, 5)

        when:
            BasicStack<Integer> sortedStack = stackSorter.sort(unsortedStack)

        then:
            sortedStack.pop() == 1
            sortedStack.pop() == 2
            sortedStack.pop() == 3
            sortedStack.pop() == 4
            sortedStack.pop() == 5
            sortedStack.pop() == 6
            sortedStack.pop() == 9
            sortedStack.pop() == 10
            sortedStack.isEmpty()
    }

    def "handles edge cases"() {
        given:
            def nullStack = null
            def emptyStack = new BasicStack<>()
            def singleElementStack = new BasicStack<>()
            singleElementStack.push(5)

        expect:
            stackSorter.sort(nullStack) == null
            stackSorter.sort(emptyStack) == emptyStack
            stackSorter.sort(singleElementStack).pop() == 5
    }

}
