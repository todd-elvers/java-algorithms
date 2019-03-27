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
        given:
            BSTNode leetCodeBST = generateTree([5, 3, 6, 2, 4, null, 7])

        when:
            leetCodeBST.delete(3)

        then:
            leetCodeBST.data == 5
            leetCodeBST.left?.data == 4
            leetCodeBST.left.left.data == 2
            leetCodeBST.left.right == null
            leetCodeBST.right.data == 6
            leetCodeBST.right.right.data == 7
            leetCodeBST.right.left == null

        when:
            bst.delete(4)

        then:
            bst.data == 5
            bst.left.data == 2
            bst.left.left.data == 1
            bst.left.right.data == 3
            bst.right.data == 6
            bst.right.left == null
            bst.right.right.data == 7
    }

    def "can correctly delete a node with two children from a huge BST"() {
        given:
            BSTNode hugeBST = generateTree([2, 0, 33, null, 1, 25, 40, null, null, 11, 31, 34, 45, 10, 18, 29, 32, null, 36, 43, 46, 4, null, 12, 24, 26, 30, null, null, 35, 39, 42, 44, null, 48, 3, 9, null, 14, 22, null, null, 27, null, null, null, null, 38, null, 41, null, null, null, 47, 49, null, null, 5, null, 13, 15, 21, 23, null, 28, 37, null, null, null, null, null, null, null, null, 8, null, null, null, 17, 19, null, null, null, null, null, null, null, 7, null, 16, null, null, 20, 6])
            BSTNode expectedBST = generateTree([2, 0, 34, null, 1, 25, 40, null, null, 11, 31, 35, 45, 10, 18, 29, 32, null, 36, 43, 46, 4, null, 12, 24, 26, 30, null, null, null, 39, 42, 44, null, 48, 3, 9, null, 14, 22, null, null, 27, null, null, 38, null, 41, null, null, null, 47, 49, null, null, 5, null, 13, 15, 21, 23, null, 28, 37, null, null, null, null, null, null, null, null, 8, null, null, null, 17, 19, null, null, null, null, null, null, null, 7, null, 16, null, null, 20, 6])

        when:
            hugeBST.delete(33)

        then: 'leetcode wanted the output in a particular order but my result is also valid so we do not compare directly'
            hugeBST.toString().size() == expectedBST.toString().size()
            !hugeBST.toString().contains("33")
            !expectedBST.toString().contains("33")

        and:
            isValidBST(hugeBST)

        when:
            hugeBST = generateTree([44,11,45,7,21,null,49,6,8,13,24,47,null,0,null,null,9,12,19,23,25,46,48,null,2,null,10,null,null,15,20,22,null,null,38,null,null,null,null,1,3,null,null,14,16,null,null,null,null,33,41,null,null,null,5,null,null,null,18,29,34,40,43,4,null,17,null,27,30,null,36,39,null,42,null,null,null,null,null,26,28,null,31,35,37,null,null,null,null,null,null,null,null,null,32])
            expectedBST = generateTree([44,11,45,7,21,null,47,6,8,13,24,46,48,0,null,null,9,12,19,23,25,null,null,null,null,null,2,null,10,null,null,15,20,22,null,null,38,1,3,null,null,14,16,null,null,null,null,33,41,null,null,null,5,null,null,null,18,29,34,40,43,4,null,17,null,27,30,null,36,39,null,42,null,null,null,null,null,26,28,null,31,35,37,null,null,null,null,null,null,null,null,null,32])

        and:
            hugeBST.delete(49)

        then: 'leetcode wanted the output in a particular order but my result is also valid so we do not compare directly'
            hugeBST.toString().size() == expectedBST.toString().size()
            !hugeBST.toString().contains("49")
            !expectedBST.toString().contains("49")

        and:
            isValidBST(hugeBST)
    }


    boolean isValidBST(BSTNode tree) {
        return isValidBST(tree, null, null);
    }

    boolean isValidBST(BSTNode node, Integer min, Integer max) {
        if(node == null) return true;

        // If a min exists we're branching right, so our node must be strictly > than the min.
        if(min != null && node.data <= min) return false;

        // If a max exists we're branching left, so our node must be strictly <= to the max.
        if(max != null && node.data > max) return false;

        return isValidBST(node.right, node.data, max) && isValidBST(node.left, min, node.data);
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

    /**
     * Generates a tree using the same input syntax that LeetCode uses.
     *
     * @param integers the integers for the array in breadth-first order
     * @return a populated tree
     */
    BSTNode generateTree(List<Integer> integers) {
        if (integers.isEmpty()) return null

        LinkedList<Integer> intQueue = new LinkedList<>(integers)
        LinkedList<BSTNode> nodeQueue = new LinkedList<>()

        BSTNode root = new BSTNode(intQueue.removeFirst())
        nodeQueue.addLast(root)

        while (!intQueue.isEmpty()) {
            BSTNode node = nodeQueue.removeFirst()
            if (node) {
                node.left = makeTreeNode(intQueue)
                nodeQueue.addLast(node.left)
            }
            if (node) {
                node.right = makeTreeNode(intQueue)
                nodeQueue.addLast(node.right)
            }
        }

        return root
    }

    private static BSTNode makeTreeNode(LinkedList<Integer> queue) {
        if (queue.isEmpty()) return null

        Integer integer = queue.removeFirst()
        return integer == null ? null : new BSTNode(integer)
    }
}
