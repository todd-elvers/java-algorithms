package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.4 - My approach
 */
public class BalancedTreeChecker {

    public boolean isBalanced(TreeNode node) {
        int leftHeight = findHeightDiff(node.left, 1);
        int rightHeight = findHeightDiff(node.right, 1);

        return Math.abs(rightHeight - leftHeight) <= 1;
    }

    private int findHeightDiff(TreeNode node, int height) {
        int left = (node.left != null) ? findHeightDiff(node.left, height + 1) : height;
        int right = (node.right != null) ? findHeightDiff(node.right, height + 1) : height;

        return Math.max(left, right);
    }

}
