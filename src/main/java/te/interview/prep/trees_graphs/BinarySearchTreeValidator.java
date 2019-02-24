package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class BinarySearchTreeValidator {

    public boolean isValidBST(TreeNode tree) {
        return isValidBST(tree, true);
    }

    private boolean isValidBST(TreeNode node, boolean isValid) {
        if (!isValid) return false;

        boolean isLeftValid =
                node.left == null || isValidBST(node.left, node.left.data <= node.data);

        boolean isRightValid =
                node.right == null || isValidBST(node.right, node.right.data > node.data);

        return isLeftValid && isRightValid;
    }

}
