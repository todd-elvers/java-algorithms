package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.4 - Book's approach
 */
public class ImprovedBalancedTreeChecker {

    boolean isBalanced(TreeNode node) {
        return checkHeight(node) != Integer.MIN_VALUE;
    }

    private int checkHeight(TreeNode node) {
        if(node == null) return -1;

        int leftHeight = checkHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDifference = leftHeight - rightHeight;
        if(Math.abs(heightDifference) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
