package te.interview.prep.trees_graphs

import spock.lang.Specification

class ChildAwareTreeNodeTest extends Specification {

    ChildAwareTreeNode n20 = [20]

    def setup() {
        n20.insertInOrder(15)
        n20.insertInOrder(17)
        n20.insertInOrder(18)
        n20.insertInOrder(16)
        n20.insertInOrder(11)
        n20.insertInOrder(14)
        n20.insertInOrder(6)
        n20.insertInOrder(8)
        n20.insertInOrder(2)
    }

    def "can determine size of tree for a given node"() {
        expect:
            n20.size == 10
    }

    def "can find a random node in the tree"() {
        given:
            def iterations = 10_000
            Map<Integer, Integer> nodeToReturnCount = [:]

        when:
            iterations.times {
                def randomNode = n20.getRandomNode()
                def returnCount = nodeToReturnCount.get(randomNode.data, 0) + 1
                nodeToReturnCount[randomNode.data] = returnCount
            }

        then:
            println("Results:")
            nodeToReturnCount.each {
                println("$it.key - $it.value")
            }
            true
    }

}
