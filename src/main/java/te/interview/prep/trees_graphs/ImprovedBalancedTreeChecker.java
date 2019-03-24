package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.4 - Book's approach
 */
public class ImprovedBalancedTreeChecker {

    boolean isBalanced(TreeNode node) {
        return checkHeight(node) != null;
    }

    private Integer checkHeight(TreeNode node) {
        if(node == null) return -1;

        Integer leftHeight = checkHeight(node.left);
        if(leftHeight == null) return null;

        Integer rightHeight = checkHeight(node.right);
        if(rightHeight == null) return null;

        if(Math.abs(leftHeight - rightHeight) > 1) {
            // Short-circuit and terminate height check eagerly
            return null;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
