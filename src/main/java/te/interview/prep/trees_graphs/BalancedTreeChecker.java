package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.4 - My approach
 */
public class BalancedTreeChecker {

    public boolean isBalanced(TreeNode node) {
        if(node == null) return true;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        boolean isNodeBalanced = Math.abs(leftHeight - rightHeight) <= 1;

        return isNodeBalanced
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    @SuppressWarnings("Duplicates")
    private int findHeight(TreeNode node) {
        if(node == null) return -1;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
