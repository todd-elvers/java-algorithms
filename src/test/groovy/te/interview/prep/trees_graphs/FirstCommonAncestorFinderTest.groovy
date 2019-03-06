package te.interview.prep.trees_graphs

import te.interview.prep.trees_graphs.domain.TreeNode

class FirstCommonAncestorFinderTest extends TreeTest {

    FirstCommonAncestorFinder commonAncestorFinder = []

    def "can determine the first common ancestor"() {
        given:
            TreeNode n5 = [5]
            TreeNode n4 = [4]
            TreeNode n6 = [6, n5, n4]

            TreeNode n8 = [8]
            TreeNode n50 = [50]
            TreeNode n9 = [9, n8, n50]

            TreeNode n10 = [10, n6, n9]

            TreeNode n11 = [11]
            TreeNode root = [1, n11, n10]

        expect:
            commonAncestorFinder.find(root, n5, n50) == n10
    }

    def "can handle edge-case where one node is ancestor of another"() {
        given:
            TreeNode n9 = [9]
            TreeNode n50 = [50]
            TreeNode n5 = [5, n50, null]
            TreeNode root = [10, n9, n5]

        expect:
            commonAncestorFinder.find(root, n5, n50) == root
    }

    def "can handle remaining edge-cases "() {
        given:
            TreeNode n1 = [1]
            TreeNode n2  = [2]
            TreeNode n3  = [3]
            TreeNode n4 = [4, n2, n3]


        expect: 'null if either node is not in the graph'
            commonAncestorFinder.find(n4, n2, n1) == null

        and: 'null if the graph is only one node'
            commonAncestorFinder.find(n1, n1, n1) == null

        and: 'null when root is null'
            commonAncestorFinder.find(null, n2, n3) == null

        and: 'null when either node to find the ancestor of is null'
            commonAncestorFinder.find(root, null, n3) == null
            commonAncestorFinder.find(root, n2, null) == null
            commonAncestorFinder.find(root, null, null) == null
    }

}
