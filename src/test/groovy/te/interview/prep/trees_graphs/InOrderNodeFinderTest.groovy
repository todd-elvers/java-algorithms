package te.interview.prep.trees_graphs

import spock.lang.Specification
import te.interview.prep.trees_graphs.domain.TreeNode

class InOrderNodeFinderTest extends TreeTest {

    InOrderNodeFinder nodeFinder = []

    def "can find the next in-order successor to a given node"() {
        given: 'our normal '
            LinkedTreeNode n7 = [7]
            LinkedTreeNode n5 = [5]
            LinkedTreeNode n6 = [6, n5, n7]

            LinkedTreeNode n1 = [1]
            LinkedTreeNode n3 = [3]
            LinkedTreeNode n2 = [2, n1, n3]

            LinkedTreeNode n4 = [4, n2, n6]

        and: 'the left sub-tree parents are set'
            n7.parent = n6
            n5.parent = n6
            n6.parent = n4

        and: 'the right sub-tree parents are set'
            n3.parent = n2
            n1.parent = n2
            n2.parent = n4

        expect:
            nodeFinder.find(n1) == n2
            nodeFinder.find(n2) == n3
            nodeFinder.find(n3) == n4
            nodeFinder.find(n4) == n5
            nodeFinder.find(n5) == n6
            nodeFinder.find(n6) == n7
            nodeFinder.find(n7) == null
    }

}
