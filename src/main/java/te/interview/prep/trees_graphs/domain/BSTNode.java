package te.interview.prep.trees_graphs.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.joining;

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

    public boolean isLeafNode() {
        return left == null && right == null;
    }

    /**
     * This allows us to use the .equals() functions provided by collections, which simplifies
     * testing.
     *
     * @return true if, and only if, object being compared to is a non-null instance of {@link
     * BSTNode} whose {@link BSTNode#data} field matches exactly.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof BSTNode)) return false;

        BSTNode otherTree = (BSTNode) obj;

        return this.data == otherTree.data;
    }

    @SuppressWarnings("Duplicates")
    public boolean deepEquals(BSTNode otherTree) {
        if (otherTree == null) return false;

        return this.data == otherTree.data
                && isSubtreeEqual(this.left, otherTree.left)
                && isSubtreeEqual(this.right, otherTree.right);
    }

    @SuppressWarnings("Duplicates")
    private boolean isSubtreeEqual(BSTNode node1, BSTNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.deepEquals(node2);
        }
    }

    public String getAllValuesAsBreadthFirstCSV() {
        List<Integer> values = new ArrayList<>();

        LinkedList<BSTNode> queue = new LinkedList<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            BSTNode node = queue.removeFirst();
            if (node == null) {
                values.add(null);
            } else {
                values.add(node.data);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return "[" + values.stream().map(String::valueOf).collect(joining(",")) + "]";
    }

    @Override
    public String toString() {
        return getAllValuesAsBreadthFirstCSV();
    }
}
