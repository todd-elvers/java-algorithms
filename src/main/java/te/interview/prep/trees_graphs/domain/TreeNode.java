package te.interview.prep.trees_graphs.domain;

public class TreeNode extends Node {
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        super(data);
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        super(data);
        this.left = left;
        this.right = right;
    }

    @Override
    Node getLeft() {
        return left;
    }

    @Override
    Node getRight() {
        return right;
    }

}
