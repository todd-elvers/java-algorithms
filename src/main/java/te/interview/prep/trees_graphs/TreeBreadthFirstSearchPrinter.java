package te.interview.prep.trees_graphs;

import java.util.LinkedList;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class TreeBreadthFirstSearchPrinter {

    public String search(TreeNode root) {
        StringBuilder visitOrder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            visitOrder
                    .append(node.data)
                    .append(",");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return visitOrder.toString();
    }

}
