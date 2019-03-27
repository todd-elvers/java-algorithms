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

    /**
     * This allows us to use the .equals() functions provided by collections,
     * which simplifies testing.
     *
     * @return true if, and only if, object being compared to is a non-null instance
     * of {@link TreeNode} whose {@link TreeNode#data} field matches exactly.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof TreeNode)) return false;

        TreeNode otherTree = (TreeNode) obj;

        return this.data == otherTree.data;
    }

    @SuppressWarnings("Duplicates")
    public boolean deepEquals(TreeNode otherTree) {
        if(otherTree == null) return false;

        return this.data == otherTree.data
                && isSubtreeEqual(this.left, otherTree.left)
                && isSubtreeEqual(this.right, otherTree.right);
    }

    @SuppressWarnings("Duplicates")
    private boolean isSubtreeEqual(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.deepEquals(node2);
        }
    }
}
