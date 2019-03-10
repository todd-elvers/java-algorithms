package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.10 Checking if t2 is a subtree of t1
 * //TODO: Review, got very close to this answer - did one recursive algorithm instead of two
 */
public class SubtreeChecker {

    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        return doSubtreesMatch(t1, t2);
    }

    private boolean doSubtreesMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;   // t1 emptied before t2 could be found
        } else if (t1.data == t2.data && doesEntireSubtreeMatch(t1, t2)) {
            return true;
        }

        return doSubtreesMatch(t1.left, t2)
                || doSubtreesMatch(t1.right, t2);
    }

    private boolean doesEntireSubtreeMatch(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;    // Ended on same leaf node
        } else if (t1 == null || t2 == null) {
            return false;   // Did not end on same leaf node
        } else if (t1.data != t2.data) {
            return false;   // Entire subtree does not match
        }

        return doesEntireSubtreeMatch(t1.left, t2.left)
                && doesEntireSubtreeMatch(t1.right, t2.right);
    }


}
