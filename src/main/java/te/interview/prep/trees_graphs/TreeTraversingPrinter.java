package te.interview.prep.trees_graphs;

import te.interview.prep.trees_graphs.domain.TreeNode;

public class TreeTraversingPrinter {

    String inOrderTraversal(TreeNode node) {
        if (node == null) return "";

        return inOrderTraversal(node.left)
                + node.data
                + inOrderTraversal(node.right);
    }

    String preOrderTraversal(TreeNode node) {
        if (node == null) return "";

        return node.data
                + preOrderTraversal(node.left)
                + preOrderTraversal(node.right);
    }

    String postOrderTraversal(TreeNode node) {
        if (node == null) return "";

        return postOrderTraversal(node.left)
                + postOrderTraversal(node.right)
                + node.data;
    }

}
