package te.interview.prep.trees_graphs

import te.interview.prep.trees_graphs.domain.TreeNode

class SubtreeCheckerTest extends TreeTest {

    SubtreeChecker subtreeChecker = []

    def "can determine when second tree is a subtree of the first"() {
        expect:
            subtreeChecker.containsTree(root, null)
            subtreeChecker.containsTree(root, n6)
            subtreeChecker.containsTree(n2, n1)
            !subtreeChecker.containsTree(n2, n6)
    }

    def "can handle edge case"() {
        given:
            TreeNode n7 = [7]
            n3.right = n7
            TreeNode n5 = [2, null, n7]

        expect:
            !subtreeChecker.containsTree(root, n5)
    }
}
