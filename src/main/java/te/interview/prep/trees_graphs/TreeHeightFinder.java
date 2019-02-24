package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class TreeHeightFinder {

    public int findHeight(TreeNode node) {
        return findHeight(node, 0);
    }

    private int findHeight(TreeNode node, int height) {
        int left = (node.left != null) ? findHeight(node.left, height + 1) : 0;
        int right = (node.right != null) ? findHeight(node.right, height + 1) : 0;

        return Math.max(height, Math.max(left, right));
    }


}
