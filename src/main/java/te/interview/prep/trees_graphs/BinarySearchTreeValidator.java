package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.5 Validate that a Binary Tree is a Binary Search Tree
 */
public class BinarySearchTreeValidator {

    public boolean isValidBST(TreeNode tree) {
        return isValidBST(tree, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;

        // If a min exists we're branching right, so our node must be strictly > than the min.
        if(min != null && node.data <= min) return false;

        // If a max exists we're branching left, so our node must be strictly <= to the max.
        if(max != null && node.data > max) return false;

        return isValidBST(node.right, node.data, max) && isValidBST(node.left, min, node.data);
    }

}
