package te.interview.prep.trees_graphs

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.trees_graphs.domain.TreeNode

class BinarySearchTreeValidatorTest extends Specification {

    @Subject
    BinarySearchTreeValidator binarySearchTreeValidator = []

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

    def "can determine if tree is a binary search tree"() {
        when:
            boolean isBST = binarySearchTreeValidator.isValidBST(root)

        then:
            isBST

        when:
            n3.right = new TreeNode(1)
            isBST = binarySearchTreeValidator.isValidBST(root)

        then:
            !isBST

        when:
            n3.right = new TreeNode(99)
            isBST = binarySearchTreeValidator.isValidBST(root)

        then:
            isBST
    }
}
