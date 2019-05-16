package te.interview.prep.trees_graphs


import spock.lang.Subject

class BSTIteratorTest extends TreeTest {

    @Subject
    BSTIterator bstIterator

    def "can properly iterate over BST nodes from smallest -> largest"() {
        given:
            bstIterator = [input]
            List<Integer> results = []

        when:
            while (bstIterator.hasNext()) {
                results << bstIterator.next()
            }

        then:
            results == output

        where:
            input                                       || output
            generateTree([7, 3, 15, null, null, 9, 20]) || [3, 7, 9, 15, 20]
            generateTree([7, 3, null, 1, 4])            || [1, 3, 4, 7]
            generateTree([7])                           || [7]
            null                                        || []
    }

}
