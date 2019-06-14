package te.interview.prep.trees_graphs;

import java.util.LinkedList;
import java.util.List;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class CousinDeterminer {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.data == x || root.data == y || x == y) return false;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode xParent = null;
        TreeNode yParent = null;

        int xHeight = 0;
        int yHeight = 0;
        int totalHeight = 0;

        // Every iteration of the loop represents one level of the tree
        while (!queue.isEmpty()) {
            List<TreeNode> parents = queue;
            queue = new LinkedList<>();

            totalHeight++;

            for (TreeNode parent : parents) {

                // Look for parent of x or y in left branch
                if (parent.left != null) {
                    queue.add(parent.left);

                    if (parent.left.data == x) {
                        xHeight = totalHeight;
                        xParent = parent;
                    }
                    if (parent.left.data == y) {
                        yHeight = totalHeight;
                        yParent = parent;
                    }
                }

                // Look for parent of x or y in right branch
                if (parent.right != null) {
                    queue.add(parent.right);

                    if (parent.right.data == x) {
                        xHeight = totalHeight;
                        xParent = parent;
                    }
                    if (parent.right.data == y) {
                        yHeight = totalHeight;
                        yParent = parent;
                    }
                }
            }
        }

        // Two nodes are cousins if they have the same height but different parents
        return xHeight == yHeight && xParent != yParent;
    }

}
