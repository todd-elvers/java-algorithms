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

    def "can validate large BST"() {
        given:
            TreeNode n6 = [6]
            TreeNode n7 = [7, n6, null]
            TreeNode n9 = [9]
            TreeNode n8 = [8, n7, n9]
            TreeNode n5 = [5, null, n8]
            TreeNode n11 = [11]
            TreeNode n10 = [10, n5, n11]
            TreeNode n12 = [12, n10, null]
            TreeNode n4 = [4, null, n12]
            TreeNode n2 = [2]
            TreeNode n1 = [1, null, n2]
            TreeNode n3 = [3, n1, n4]
            TreeNode n18 = [18]
            TreeNode n14 = [14, null, n18]
            TreeNode rootOfLargeBST = [13, n3, n14]

        expect:
            binarySearchTreeValidator.isValidBST(rootOfLargeBST)
    }
}
