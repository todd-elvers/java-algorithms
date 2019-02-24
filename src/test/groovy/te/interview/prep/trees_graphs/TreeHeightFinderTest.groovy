package te.interview.prep.trees_graphs

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.trees_graphs.domain.TreeNode

class TreeHeightFinderTest extends Specification {

    @Subject
    TreeHeightFinder treeHeightFinder = []

    TreeNode n3 = [3]
    TreeNode n6 = [6]
    TreeNode n5 = [5, n3, n6]

    TreeNode n1 = [1]
    TreeNode n7 = [7]
    TreeNode n2 = [2, n1, n7]

    /**
              4
            /   \
           2     5
          / \   / \
         1   7 3   6
     */
    TreeNode root = [4, n2, n5]


    def "can determine the height of a graph"() {
        when:
            int height = treeHeightFinder.findHeight(root)

        then:
            height == 2

        when:
            n3.right = new TreeNode(5)
            height = treeHeightFinder.findHeight(root)

        then:
            height == 3

        when:
            n3.right.right = new TreeNode(5)
            height = treeHeightFinder.findHeight(root)

        then:
            height == 4

        when: 'we try to find the height of one of the leaf nodes'
            height = treeHeightFinder.findHeight(n6)

        then: 'we did check the height of a leaf node and it was 0'
            n6.isLeafNode()
            height == 0
    }
}
