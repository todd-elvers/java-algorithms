package te.interview.prep.trees_graphs

import spock.lang.Specification
import te.interview.prep.trees_graphs.domain.TreeNode

class TreeDiameterFinderTest extends Specification {

    TreeDiameterFinder treeDiameterFinder = []

    def "can find diameter of a BT"() {
        given:
            TreeNode n4 = [4]
            TreeNode n5 = [5]
            TreeNode n2 = [2, n4, n5]
            TreeNode n3 = [3]
            TreeNode root = [1, n2, n3]

        expect:
            treeDiameterFinder.diameterOfBinaryTree(root) == 3
    }

    def "can find the diameter of a huge BT"() {
        given:
            TreeNode n_1 = [-1]
            TreeNode n0 = [0, null, n_1]
            TreeNode n_4 = [-4]
            TreeNode n6 = [6, n_4, null]
            TreeNode n6b = [6, n0, n6]
            TreeNode n9 = [9, n6b, null]

        and:
            TreeNode n_2 = [-2]
            TreeNode n9b = [9, n_2, null]
            TreeNode n_6 = [-6, n9b, null]
            TreeNode n5 = [5]
            TreeNode n_6b = [-6, n5, null]
            TreeNode n_7 = [-7, n_6b, n_6]

        and:
            TreeNode n_9 = [-9, n9, n_7]
            TreeNode n_4b = [-4]
            TreeNode n_3 = [-3, n_4b, null]
            TreeNode n_3b = [-3, n_9, n_3]

        and:
            TreeNode n_7b = [-7]
            TreeNode n4 = [4, n_7b, n_3b]

        expect:
            treeDiameterFinder.diameterOfBinaryTree(n4) == 8
    }

}
