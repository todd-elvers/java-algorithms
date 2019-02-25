package te.interview.prep.trees_graphs.domain;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public boolean isLeafNode() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
