package te.interview.prep.trees_graphs


import spock.lang.Subject
import te.interview.prep.trees_graphs.domain.TreeNode

class BinarySearchTreeValidatorTest extends TreeTest {

    @Subject
    BinarySearchTreeValidator binarySearchTreeValidator = []

    TreeNode n25 = [25]
    TreeNode n10 = [25, null, n25]
    TreeNode n30 = [30]
    TreeNode rootOfInvalidBST = [30, n10, n30]

    def "can determine if tree is a binary search tree"() {
        when:
            boolean isBST = binarySearchTreeValidator.isValidBST(root)

        then:
            isBST

        when:
            n7.right = new TreeNode(1)
            isBST = binarySearchTreeValidator.isValidBST(root)

        then:
            !isBST

        when:
            n3.right = new TreeNode(99)
            isBST = binarySearchTreeValidator.isValidBST(root)

        then:
            !isBST

        when:
            isBST = binarySearchTreeValidator.isValidBST(rootOfInvalidBST)

        then:
            !isBST
    }
}
