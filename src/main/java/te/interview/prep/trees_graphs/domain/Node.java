package te.interview.prep.trees_graphs.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.joining;

abstract class Node {
    public int data;

    public Node(int data){
        this.data = data;
    }
    
    abstract Node getLeft();
    abstract Node getRight();

    public boolean isLeafNode() {
        return getLeft() == null && getRight() == null;
    }

    /**
     * This allows us to use the .equals() functions provided by collections,
     * which simplifies testing.
     *
     * @return true if, and only if, object being compared to is a non-null instance
     * of {@link TreeNode} whose {@link TreeNode#data} field matches exactly.
     */
    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(!(other instanceof Node)) return false;

        return this.data == ((Node) other).data;
    }

    @SuppressWarnings("Duplicates")
    public boolean deepEquals(Node otherTree) {
        if(otherTree == null) return false;

        return this.data == otherTree.data
                && isSubtreeEqual(this.getLeft(), otherTree.getLeft())
                && isSubtreeEqual(this.getRight(), otherTree.getRight());
    }

    @SuppressWarnings("Duplicates")
    private boolean isSubtreeEqual(Node node1, Node node2) {
        if(node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.deepEquals(node2);
        }
    }

    public String getAllValuesAsBreadthFirstCSV() {
        List<Integer> values = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            if (node == null) {
                values.add(null);
            } else {
                values.add(node.data);
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }

        return "[" + values.stream().map(String::valueOf).collect(joining(",")) + "]";
    }

    public String toString() {
        return getAllValuesAsBreadthFirstCSV();
    }
}
