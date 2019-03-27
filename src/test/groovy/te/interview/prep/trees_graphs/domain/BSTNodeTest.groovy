package te.interview.prep.trees_graphs.domain

import spock.lang.Specification

class BSTNodeTest extends Specification {

    BSTNode n7 = [7]
    BSTNode n5 = [5]
    BSTNode n6 = [6, n5, n7]

    BSTNode n1 = [1]
    BSTNode n3 = [3]
    BSTNode n2 = [2, n1, n3]

    /**
     A valid BST to simplify testing.

                      4
                    /   \
                   2     6
                 /  \   / \
                1    3 5   7
     */
    BSTNode bst = [4, n2, n6]
    
    def "we can find any node in a BST"() {
        expect:
            bst.find(1)
            bst.find(2)
            bst.find(3)
            bst.find(4)
            bst.find(5)
            bst.find(6)
            bst.find(7)

        and: 'we return null for nodes that do not exist'
            !bst.find(0)
            !bst.find(8)
    }

    def "we can correctly insert nodes into a BST"() {
        when:
            bst.insert(8)

        then:
            n7.right == new BSTNode(8)

        when:
            bst.insert(0)

        then:
            n1.left == new BSTNode(0)
    }

    def "can correctly delete leaf nodes from a BST"() {
        given:
            bst.delete(5)

        expect:
            n6.left == null
    }

    def "can correctly delete nodes with a single child from a BST"() {
        given:
            n7.right = new BSTNode(9)
            n1.left = new BSTNode(0)

        when: 'we delete a node with a right child'
            bst.delete(7)

        then: 'it is swapped correctly'
            n6.right.data == 9

        when: 'we delete a node with a left child'
            bst.delete(1)

        then: 'it is also swapped correctly'
            n2.left.data == 0
    }

    def "can correctly delete nodes with two children from a BST"() {
        when:
            bst.delete(4)

        then:
            bst.data == 5
            bst.left.data == 2
            bst.right.data == 6
            bst.right.left == null
            bst.right.right.data == 7
            bst.left.left.data == 1
            bst.left.right.data == 3
    }

    def "can correctly determine if a node is a leaf node"() {
        expect:
            n7.isLeafNode()
            n5.isLeafNode()
            n1.isLeafNode()
            n3.isLeafNode()
            !n2.isLeafNode()
            !n6.isLeafNode()
            !bst.isLeafNode()
    }

}
