package te.interview.prep.trees_graphs

import spock.lang.Specification
import te.interview.prep.trees_graphs.domain.TreeNode

abstract class TreeTest extends Specification {

    TreeNode n7 = [7]
    TreeNode n5 = [5]
    TreeNode n6 = [6, n5, n7]

    TreeNode n1 = [1]
    TreeNode n3 = [3]
    TreeNode n2 = [2, n1, n3]

    /**
             4
           /   \
          2     6
         / \   / \
        1   3 5   7
     */
    TreeNode root = [4, n2, n6]

    /**
     * @return true if, and only if, all nodes in the tree adhere to the following
     * rule: Left(n) <= n < Right(n), where Left() is all nodes left of n, and Right()
     * is all nodes right of n.
     */
    boolean isBinarySearchTree(TreeNode node) {
        new BinarySearchTreeValidator().isValidBST(node)
    }

    /**
     * @return the height of a tree (i.e. the number of levels)
     */
    int findHeightOfTree(TreeNode node) {
        new TreeHeightFinder().findHeight(node)
    }

    /**
     * Prints all the nodes in a tree. Nodes with * next to them are leaf nodes.
     */
    void printTree( TreeNode node) {
        if(!node || node.isLeafNode()) return

        def printNode = { TreeNode n ->
            node?.data ? node?.data + (node.isLeafNode() ? "*" : " ") : "  "
        }

        println("   $node.data")
        println("  / \\")
        println(" ${printNode(node.left)}  ${printNode(node.right)}")

        printTree(node.left)
        printTree(node.right)
    }

}
