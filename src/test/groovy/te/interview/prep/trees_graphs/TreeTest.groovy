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

    TreeNode root = [4, n2, n5]

    def "can determine the height of a graph"() {
        expect:
            findHeightOfTree(root) == 2
    }

    def "can determine if tree is a binary search tree"() {
        expect:
            isBinarySearchTree(root)
    }

    // Left(n) <= n < Right(n)
    boolean isBinarySearchTree(TreeNode node, boolean isValid = true) {
        if (!isValid) return false

        boolean isLeftValid = (node.left) ? isBinarySearchTree(node.left, node.left.data <= node.data) : true
        boolean isRightValid = (node.right) ? isBinarySearchTree(node.right, node.right.data > node.data) : true

        return isLeftValid && isRightValid
    }

    // Tree with only one node = height of 0
    int findHeightOfTree(TreeNode node, int height = 0) {
        Integer left = (node.left) ? findHeightOfTree(node.left, height + 1) : 0
        Integer right = (node.right) ? findHeightOfTree(node.right, height + 1) : 0

        return Math.max(height, Math.max(left, right))
    }

}
