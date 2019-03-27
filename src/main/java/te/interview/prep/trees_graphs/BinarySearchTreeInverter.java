package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class BinarySearchTreeInverter {

    public TreeNode invert(TreeNode node) {
        if(node == null) return null;
        if(node.isLeafNode()) return node;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        node.left = invert(node.left);
        node.right = invert(node.right);
        return node;
    }

}
