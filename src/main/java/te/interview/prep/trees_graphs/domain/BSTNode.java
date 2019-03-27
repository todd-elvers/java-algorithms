package te.interview.prep.trees_graphs.domain;

public class BSTNode extends Node {
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int data) {
        super(data);
    }

    public BSTNode(int data, BSTNode left, BSTNode right) {
        super(data);
        this.left = left;
        this.right = right;
    }

    public BSTNode find(int data) {
        if (data == this.data) {
            return this;
        } else if (data < this.data) {
            return (this.left == null) ? null : this.left.find(data);
        } else {
            return (this.right == null) ? null : this.right.find(data);
        }
    }

    public void insert(int data) {
        if (data < this.data) {
            if (this.left == null) {
                this.left = new BSTNode(data);
            } else {
                this.left.insert(data);
            }
        } else if (data > this.data) {
            if (this.right == null) {
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
        if (node == null) return null;

        if (dataToDelete < node.data) {
            node.left = delete(node.left, dataToDelete);
        } else if (dataToDelete > node.data) {
            node.right = delete(node.right, dataToDelete);
        } else {
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            } else {
                BSTNode inOrderSuccessor = findLeftMostNode(node.right);
                swapData(inOrderSuccessor, node);
                node.right = delete(node.right, dataToDelete);
            }
        }

        return node;
    }

    private BSTNode findLeftMostNode(BSTNode node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return findLeftMostNode(node.left);
    }

    private void swapData(BSTNode first, BSTNode second) {
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }
}
