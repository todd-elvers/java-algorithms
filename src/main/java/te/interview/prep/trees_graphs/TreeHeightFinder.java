package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class TreeHeightFinder {

    public int findHeight(TreeNode node) {
        return findHeight(node, 0);
    }

    private int findHeight(TreeNode node, int height) {
        if(node == null) return height;
        if(node.left == null && node.right == null) return height;

        int leftHeight = findHeight(node.left, height);
        int rightHeight = findHeight(node.right, height);

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
