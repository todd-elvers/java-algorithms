package te.interview.prep.trees_graphs


import te.interview.prep.trees_graphs.domain.TreeNode

class BalancedTreeCheckerTest extends TreeTest {

    BalancedTreeChecker balancedTreeChecker = []
    ImprovedBalancedTreeChecker improvedBalancedTreeChecker = []

    def "can tell whether a tree's subtrees differ in height by more than one"() {
        when:
            boolean isBalanced = balancedTreeChecker.isBalanced(binarySearchTree)
            boolean isBalancedImproved = improvedBalancedTreeChecker.isBalanced(binarySearchTree)

        then:
            isBalanced
            isBalancedImproved

        when:
            n7.right = new TreeNode(10)
            isBalanced = balancedTreeChecker.isBalanced(binarySearchTree)
            isBalancedImproved = improvedBalancedTreeChecker.isBalanced(binarySearchTree)


        then:
            isBalanced
            isBalancedImproved

        when:
            n7.right.right = new TreeNode(11)
            isBalanced = balancedTreeChecker.isBalanced(binarySearchTree)
            isBalancedImproved = improvedBalancedTreeChecker.isBalanced(binarySearchTree)

        then:
            !isBalanced
            !isBalancedImproved

        when: 'we re-balance the tree again'
            n1.left = new TreeNode(12)
            n5.left = new TreeNode(30)
            n7.left = new TreeNode(40)
            isBalanced = balancedTreeChecker.isBalanced(binarySearchTree)
            isBalancedImproved = improvedBalancedTreeChecker.isBalanced(binarySearchTree)

        then: 'our code returns true again'
            isBalanced
            isBalancedImproved
    }

}
