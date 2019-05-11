package te.interview.prep.trees_graphs;

import java.util.HashMap;
import java.util.Map;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.12 - Count all paths through a BT that result in a given sum
 *
 *      Runtime:
 *          - For a balanced tree: O(n log n) since we're performing n
 *            operations on an increasingly smaller set of n elements.
 *              - Also, the depth of a balanced tree with n elements is log n,
 *                so with n calls to the depth of the tree we're doing O(n log n)
 *                work
 *          - For unbalanced trees: O(n^2) since we may end up traversing
 *            the same nodes repeatedly, for instance if the tree is just
 *            single node nodes all on one side
 */
public class SumPathCounter {

    int countAllPathsWithSum(TreeNode node, int targetSum) {
        if(node == null) return 0;

        // Count all paths that equal targetSum from current node
        int sumCount = countPathsWithSum(node, targetSum, 0);

        // Count all paths tha equal targetSum for left subtree & right subtree
        sumCount += countAllPathsWithSum(node.left, targetSum);
        sumCount += countAllPathsWithSum(node.right, targetSum);

        return sumCount;
    }

    int countPathsWithSum(TreeNode node, int targetSum, int runningSum) {
        if(node == null) return 0;

        runningSum += node.data;
        int sumCount = (runningSum == targetSum) ? 1 : 0;

        sumCount += countPathsWithSum(node.left, targetSum, runningSum);
        sumCount += countPathsWithSum(node.right, targetSum, runningSum);

        return sumCount;
    }

    /**
     * Optimized solution that trades space complexity for better runtime complexity.
     *
     *      Runtime:
     *          - Whether the tree is balanced or not, we only do O(n) work since
     *            we travel to each node just once and do O(1) work each time.
     *
     *      Space:
     *          - For balanced tree: O(log n)
     *          - For unbalanced tree: O(n)
     */
    class Optimized {

        int countPathsWithSum(TreeNode root, int targetSum) {
            return countPathsWithSum(root, targetSum, 0, new HashMap<>());
        }

        private int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
            if(node == null) return 0;

            /* Count paths with sum ending at the current node */
            runningSum += node.data;
            int sum = runningSum - targetSum;
            int totalPaths = pathCount.getOrDefault(sum, 0);

            /* Edge case: runningSum = targetSum means an additional path starts from the root */
            if(runningSum == targetSum) totalPaths++;

            /* Increment pathCount as we recurse, then undo our increment afterwords */
            updatePathCount(pathCount, runningSum, 1);
            totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
            totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
            updatePathCount(pathCount, runningSum, -1);

            return totalPaths;
        }

        private void updatePathCount(Map<Integer, Integer> pathCount, int key, int delta) {
            int newCount = pathCount.getOrDefault(key, 0) + delta;
            pathCount.put(key, newCount);
        }

    }

}
