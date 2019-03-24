package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class TreeHeightFinder {

    public int findHeight(TreeNode node) {
        if(node == null) return -1;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
