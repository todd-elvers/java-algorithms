package te.interview.prep.trees_graphs.domain


import te.interview.prep.trees_graphs.TreeTest

class TreeNodeTest extends TreeTest {

    def "deepEquals correctly determines whether an entire subtree is equal or not"() {
        given:
            TreeNode n7 = [7]
            TreeNode n5 = [5]
            TreeNode n6 = [6, n5, n7]

            TreeNode n1 = [1]
            TreeNode n3 = [3]
            TreeNode n2 = [2, n1, n3]

            TreeNode root2 = [4, n2, n6]

        when:
            def isDeepEqual = binarySearchTree.deepEquals(root2)

        then:
            isDeepEqual

        when:
            root2.left = new TreeNode(100)
            isDeepEqual = binarySearchTree.deepEquals(root2)

        then:
            !isDeepEqual
    }

    def "can correctly determine if a node is a leaf node"() {
        expect:
            n7.isLeafNode()
            n5.isLeafNode()
            n1.isLeafNode()
            n3.isLeafNode()
            !n2.isLeafNode()
            !n6.isLeafNode()
            !binarySearchTree.isLeafNode()
    }

}
