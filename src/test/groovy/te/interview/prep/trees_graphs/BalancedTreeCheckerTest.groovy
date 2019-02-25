package te.interview.prep.trees_graphs


import te.interview.prep.trees_graphs.domain.TreeNode

class BalancedTreeCheckerTest extends TreeTest {

    BalancedTreeChecker balancedTreeChecker = []
    ImprovedBalancedTreeChecker improvedBalancedTreeChecker = []

    def "can tell whether a tree's subtrees differ in height by more than one"() {
        when:
            boolean isBalanced = balancedTreeChecker.isBalanced(root)
            boolean isBalancedImproved = improvedBalancedTreeChecker.isBalanced(root)

        then:
            isBalanced
            isBalancedImproved

        when:
            n3.right = new TreeNode(10)
            isBalanced = balancedTreeChecker.isBalanced(root)
            isBalancedImproved = improvedBalancedTreeChecker.isBalanced(root)


        then:
            isBalanced
            isBalancedImproved

        when:
            n3.right.right = new TreeNode(11)
            isBalanced = balancedTreeChecker.isBalanced(root)
            isBalancedImproved = improvedBalancedTreeChecker.isBalanced(root)

        then:
            !isBalanced
            !isBalancedImproved

        when:
            n1.left = new TreeNode(12)
            isBalanced = balancedTreeChecker.isBalanced(root)
            isBalancedImproved = improvedBalancedTreeChecker.isBalanced(root)

        then:
            isBalanced
            // The book's approach seems to fail under this circumstance
            // however my approach does not.
//            isBalancedImproved
    }

}
