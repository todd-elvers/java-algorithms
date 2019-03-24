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

    /**
     * @return true if, and only if, if the current nodes and all child nodes of this
     * tree and `otherTree` match exactly.  (i.e. subtree equality instead of node equality)
     * //TODO: Test this method
     */
    public boolean deepEquals(TreeNode otherTree) {
        if(otherTree == null) return false;

        return this.data == otherTree.data
                && isLeftNodeEqual(this, otherTree)
                && isRightNodeEqual(this, otherTree);
    }
    
    private boolean isLeftNodeEqual(TreeNode node1, TreeNode node2) {
        if(node1.left == null && node2.left == null) {
            return true;
        } else if(node1.left == null || node2.left == null) {
            return false;
        } else {
            return node1.left.deepEquals(node2.left);
        }
    }
    
    private boolean isRightNodeEqual(TreeNode node1, TreeNode node2) {
        if(node1.right == null && node2.right == null) {
            return true;
        } else if(node1.right == null || node2.right == null) {
            return false;
        } else {
            return node1.right.deepEquals(node2.right);
        }
    }
}
