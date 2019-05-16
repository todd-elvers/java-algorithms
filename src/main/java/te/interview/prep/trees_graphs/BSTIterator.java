package te.interview.prep.trees_graphs;

import java.util.Stack;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/binary-search-tree-iterator/">Problem on leetcode</a>
 */
public class BSTIterator {

    private TreeNode previous;
    private Stack<TreeNode> parents;

    public BSTIterator(TreeNode root) {
        this.previous = null;
        this.parents = new Stack<>();
        if (root != null) parents.push(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = findNextInOrderNode();
        previous = node;
        return node.data;
    }

    private TreeNode findNextInOrderNode() {
        if (previous == null) {
            // First iteration: find left-most child of root (or root if none)
            return leftMostOrSelf(parents.pop());
        } else if (previous.right == null) {
            // Either the parent of `previous` or the next parent greater than `previous`
            return parents.pop();
        } else {
            return leftMostOrSelf(previous.right);
        }
    }

    private TreeNode leftMostOrSelf(TreeNode node) {
        TreeNode leftMost = node;
        while (leftMost.left != null) {
            parents.push(leftMost);
            leftMost = leftMost.left;
        }
        return leftMost;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !parents.isEmpty() || (previous != null && previous.right != null);
    }

}
