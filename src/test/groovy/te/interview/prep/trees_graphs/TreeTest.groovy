package te.interview.prep.trees_graphs

import spock.lang.Specification
import te.interview.prep.trees_graphs.domain.TreeNode

abstract class TreeTest extends Specification {

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
            int height = findHeightOfTree(root)

        then:
            height == 2

        when:
            n3.right = new TreeNode(5)
            height = findHeightOfTree(root)

        then:
            height == 3

        when:
            n3.right.right = new TreeNode(5)
            height = findHeightOfTree(root)

        then:
            height == 4

        when: 'we try to find the height of one of the leaf nodes'
            height = findHeightOfTree(n6)

        then: 'we did check the height of a leaf node and it was 0'
            n6.isLeafNode()
            height == 0
    }

    def "can determine if tree is a binary search tree"() {
        when:
            boolean isBST = isBinarySearchTree(root)

        then:
            isBST

        when:
            n3.right = new TreeNode(1)
            isBST = isBinarySearchTree(root)

        then:
            !isBST

        when:
            n3.right = new TreeNode(99)
            isBST = isBinarySearchTree(root)

        then:
            isBST
    }

    /**
     * @return true if, and only if, all nodes in the tree adhere to the following
     * rule: Left(n) <= n < Right(n), where Left() is all nodes left of n, and Right()
     * is all nodes right of n.
     */
    boolean isBinarySearchTree(TreeNode node, boolean isValid = true) {
        if (!isValid) return false

        boolean isLeftValid = (node.left) ? isBinarySearchTree(node.left, node.left.data <= node.data) : true
        boolean isRightValid = (node.right) ? isBinarySearchTree(node.right, node.right.data > node.data) : true

        return isLeftValid && isRightValid
    }

    /**
     * @return the height of a tree (i.e. the number of levels)
     */
    int findHeightOfTree(TreeNode node, int height = 0) {
        Integer left = (node.left) ? findHeightOfTree(node.left, height + 1) : 0
        Integer right = (node.right) ? findHeightOfTree(node.right, height + 1) : 0

        return Math.max(height, Math.max(left, right))
    }


}
