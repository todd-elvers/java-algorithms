package te.interview.prep.trees_graphs;

import java.util.LinkedList;
import java.util.List;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class CousinDeterminer {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.data == x || root.data == y || x == y) return false;

        List<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        TreeNode xParent = null, yParent = null;
        int xHeight = 0, yHeight = 0, height = 0;

        // Every iteration of the loop represents one level of the tree
        while (!queue.isEmpty()) {
            List<TreeNode> parents = queue;
            queue = new LinkedList<>();
            height++;

            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    queue.add(parent.left);
                    if (parent.left.data == x) {
                        xHeight = height;
                        xParent = parent;
                    }
                    if (parent.left.data == y) {
                        yHeight = height;
                        yParent = parent;
                    }
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                    if (parent.right.data == x) {
                        xHeight = height;
                        xParent = parent;
                    }
                    if (parent.right.data == y) {
                        yHeight = height;
                        yParent = parent;
                    }
                }
            }
        }

        return xHeight == yHeight && xParent != yParent;
    }

}
