package te.interview.prep.trees_graphs

import spock.lang.Subject
import te.interview.prep.trees_graphs.domain.TreeNode

class SumPathCounterTest extends TreeTest {

    @Subject
    SumPathCounter sumPathCounter = []
    SumPathCounter.Optimized optimizedSumPathCounter = []

    TreeNode n_1 = [-1]
    TreeNode n4 = [4, null, n_1]
    TreeNode n_2a = [-2]
    TreeNode n3 = [3, n4, n_2a]
    TreeNode n1 = [1]
    TreeNode n_2b = [-2, n1, null]
    TreeNode root = [5, n3, n_2b]

    def "can count number of paths that sum to targetSum from root"() {
        expect:
            sumPathCounter.countPathSumsFromNode(root, 6, 0) == 1
    }

    def 'can count number of paths that sum to targetSum for entire tree'() {
        expect:
            sumPathCounter.countPathSumsForEntireTree(root, 6) == 2
            optimizedSumPathCounter.countPathsWithSum(root, 6) == 2
    }

}
