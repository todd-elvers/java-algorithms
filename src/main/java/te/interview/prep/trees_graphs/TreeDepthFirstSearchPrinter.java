package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class TreeDepthFirstSearchPrinter {

    public String search(TreeNode node) {
        StringBuilder visitOrder = new StringBuilder();
        search(node, visitOrder);
        return visitOrder.toString();
    }

    private void search(TreeNode node, StringBuilder visitOrder) {
        if (node == null) return;

        visitOrder
                .append(node.data)
                .append(",");

        search(node.left, visitOrder);
        search(node.right, visitOrder);
    }
}
