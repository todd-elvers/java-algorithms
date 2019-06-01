package te.interview.prep.data_structures.disjoint_set;

import java.util.HashMap;
import java.util.Map;

// Simpler, easier to remember implementation of DisjointSet
public class IntegerDisjointSet {
    private final Map<Integer, Node> valueToNode;

    public IntegerDisjointSet(int[] ints) {
        valueToNode = new HashMap<>();
        for (int n : ints) valueToNode.put(n, new Node(n));
    }

    public Integer find(int n) {
        Node set = findSet(valueToNode.get(n));
        return (set == null) ? null : set.value;
    }

    private Node findSet(Node node) {
        if (node == null) return null;
        if (node != node.parent) node.parent = findSet(node.parent);
        return node.parent;
    }

    public void union(int x, int y) {
        Integer xSetValue = find(x), ySetValue = find(y);
        if (xSetValue == null || ySetValue == null || xSetValue.equals(ySetValue)) return;
        unionByRank(valueToNode.get(xSetValue), valueToNode.get(ySetValue));
    }

    private void unionByRank(Node x, Node y) {
        if (x.rank < y.rank) {
            x.parent = y;
        } else {
            y.parent = x;
            if (x.rank == y.rank) y.rank++;
        }
    }

    public void remove(int x) {
        Integer set = find(x);
        if (set == null) return;
        valueToNode.keySet().removeIf(key -> !key.equals(set) && find(key).equals(set));
        valueToNode.remove(set);
    }


    private static class Node {
        int rank;
        int value;
        Node parent;

        Node(int value) {
            this.value = value;
            this.rank = 0;
            this.parent = this;
        }
    }
}
