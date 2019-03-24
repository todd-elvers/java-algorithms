package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * Got this problem from Leetcode.  The solution that involves no local state
 * is very inefficient.  I recognize local state is bad, and that I probably won't
 * get a question like this in an interview, but I put it on here because I spent
 * a while trying to find the answer to it, only to find the answer was pretty lame.
 */
public class TreeDiameterFinder {

    private int maxNodesTraversed = 0;

    public int diameterOfBinaryTree(TreeNode node) {
        findMaxHeight(node);
        return maxNodesTraversed + 1;
    }

    private int findMaxHeight(TreeNode node) {
        if(node == null) return -1;

        int leftHeight = findMaxHeight(node.left);
        int rightHeight = findMaxHeight(node.right);

        maxNodesTraversed = Math.max(maxNodesTraversed, leftHeight + rightHeight + 1);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
