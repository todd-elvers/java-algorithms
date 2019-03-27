package te.interview.prep.trees_graphs.domain;

public class BSTNode {
    public int data;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int data) {
        this(data, null, null);
    }

    public BSTNode(int data, BSTNode left, BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BSTNode find(int data) {
        if(data == this.data) {
            return this;
        } else if(data < this.data) {
            return (this.left == null) ? null : this.left.find(data);
        } else {
            return (this.right == null) ? null : this.right.find(data);
        }
    }

    public void insert(int data) {
        if(data < this.data) {
            if(this.left == null) {
                this.left = new BSTNode(data);
            } else {
                this.left.insert(data);
            }
        } else if (data > this.data) {
            if(this.right == null) {
                this.right = new BSTNode(data);
            } else {
                this.right.insert(data);
            }
        } else {
            throw new RuntimeException("Node with value '" + data + "' already exists.");
        }
    }

    public void delete(int data) {
        delete(this, data);
    }

    public BSTNode delete(BSTNode node, int dataToDelete) {
        if(node == null) return null;

        if(dataToDelete < node.data) {
            node.left = delete(node.left, dataToDelete);
        } else if(dataToDelete > node.data) {
            node.right = delete(node.right, dataToDelete);
        } else {
            node = handleNodeDeletionCases(node, dataToDelete);
        }

        return node;
    }

    /**
     * Handles the 3 cases that exist when removing a node from a Binary Search Tree:
     *  1.) Node to delete is a leaf node
     *  2.) Node to delete has a single child (left or right)
     *  3.) Node to delete has two children
     */
    private BSTNode handleNodeDeletionCases(BSTNode node, int dataToDelete) {
        if(node.left != null && node.right != null) {
            BSTNode inOrderSuccessor = findLeftMostNode(node.right);
            swapData(inOrderSuccessor, node);
            node = delete(node.right, dataToDelete);
        } else if (node.left != null) {
            node.data = node.left.data;
            node.left = node.left.left;
        } else if (node.right != null) {
            node.data = node.right.data;
            node.right = node.right.right;
        } else {
            node = null;
        }

        return node;
    }

    private void swapData(BSTNode first, BSTNode second) {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    private BSTNode findLeftMostNode(BSTNode node) {
        if(node == null) return null;
        if(node.left == null) return node;
        return findLeftMostNode(node.left);
    }

    public boolean isLeafNode() {
        return left == null && right == null;
    }

    /**
     * This allows us to use the .equals() functions provided by collections,
     * which simplifies testing.
     *
     * @return true if, and only if, object being compared to is a non-null instance
     * of {@link BSTNode} whose {@link BSTNode#data} field matches exactly.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof BSTNode)) return false;

        BSTNode otherTree = (BSTNode) obj;

        return this.data == otherTree.data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
