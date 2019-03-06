package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

/**
 * 4.8 Find first common ancestor of two nodes in a binary tree
 *  - Runtime: O(n) on a balanced tree
 */
public class FirstCommonAncestorFinder {

    TreeNode find(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) return null;
        if (root.right == null && root.left == null) return null;
        if (rootNodeIsFirstCommonAncestor(root, node1, node2)) return root;
        if (!doesTreeContainBothNodes(root, node1, node2)) return null;

        TreeNode current = root, firstCommonAncestor = null;

        // Optimization: only search right subtree if left subtree does not contain an ancestor
        // Optimization: while-loop isn't necessary if we use recursion
        while (current != null && (current != node1 || current != node2)) {
            TreeNode left = findCommonAncestor(current.left, node1, node2);
            TreeNode right = findCommonAncestor(current.right, node1, node2);

            if (left != null && left != node1 && left != node2) {
                // Left subtree has ancestor
                current = left;
            } else if(right != null && right != node1 && right != node2) {
                // Right subtree has ancestor
                current = right;
            } else {
                // Neither subtree has ancestor, so current node is the first common ancestor
                firstCommonAncestor = current;
                current = null;
            }
        }

        return firstCommonAncestor;
    }

    /**
     * @return node1 if only node1 is found; node2 if only node2 is found; null if neither node1 or
     * node2 is found; lastly a non-null node if a common ancestor of both node1 & node2 is found
     */
    private TreeNode findCommonAncestor(TreeNode node, TreeNode node1, TreeNode node2) {
        if (node == null) return null;

        boolean hasNode1 = treeContainsNode(node, node1);
        boolean hasNode2 = treeContainsNode(node, node2);

        if (hasNode1 && hasNode2) {
            return node;
        } else if (hasNode1) {
            return node1;
        } else if (hasNode2) {
            return node2;
        } else {
            return null;
        }
    }

    private boolean treeContainsNode(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;

        return treeContainsNode(root.left, node) || treeContainsNode(root.right, node);
    }

    private boolean rootNodeIsFirstCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        return (root.left == node1 && root.right == node2) || (root.left == node2 && root.right == node1);
    }

    private boolean doesTreeContainBothNodes(TreeNode root, TreeNode node1, TreeNode node2) {
        return treeContainsNode(root, node1) && treeContainsNode(root, node2);
    }
}
