package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">Problem on leetcode</a>
 */
public class BinarySearchTreeInverter {

    public TreeNode invert(TreeNode node) {
        if(node == null) return null;

        swapLeftAndRight(node);

        node.left = invert(node.left);
        node.right = invert(node.right);

        return node;
    }

    private void swapLeftAndRight(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

}
