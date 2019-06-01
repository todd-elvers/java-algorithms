package te.interview.prep.data_structures.disjoint_set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generic Disjoint Set implementation that uses union-by-rank and path
 * compression to approximate O(log*(n)) complexity for find & merge
 * operations.  (e.g. If n = 2^65536, log*(n) = 5).
 */
public class GenericDisjointSet<T> {
    private final Map<T, Node<T>> valuesToNodes;

    public GenericDisjointSet(Collection<T> values) {
        this.valuesToNodes = new HashMap<>(values.size());
        values.forEach(value ->
                valuesToNodes.put(value, new Node<>(value))
        );
    }

    /**
     * @return the set representative for the given object, or null if the object
     * does not belong to any set.
     */
    public T find(T value) {
        Node<T> node = valuesToNodes.get(value);
        Node<T> setRepresentative = findWithPathCompression(node);
        return (setRepresentative == null) ? null : setRepresentative.value;
    }

    private Node<T> findWithPathCompression(Node<T> node) {
        if (node == null) return null;

        // Path compression: flatten each parent tree to a constant depth (i.e. update parent ref to set rep.)
        if (node != node.parent) {
            node.parent = findWithPathCompression(node.parent);
        }

        return node.parent;
    }

    /**
     * Removes all elements belonging to the set of the given value.
     * Has no effect if the given value does not belong to any set.
     */
    public void removeSet(T value) {
        T set = find(value);
        if(set == null) return;

        // Remove all elements pointing to set representative
        valuesToNodes.keySet().removeIf(key ->
                !Objects.equals(key, set) && Objects.equals(find(key), set)
        );

        // Remove set representative
        valuesToNodes.remove(set);
    }

    /**
     * Unions the set representative of x with the set representative of y.
     * Has no effect if either x or y are not in any set or are already in the same set.
     */
    public void union(T x, T y) {
        T xSetValue = find(x), ySetValue = find(y);
        if (xSetValue == null || ySetValue == null || Objects.equals(x, y)) return;

        unionByRank(
                valuesToNodes.get(xSetValue),
                valuesToNodes.get(ySetValue)
        );
    }

    private void unionByRank(Node xSet, Node ySet) {
        if (xSet.rank < ySet.rank) {
            xSet.parent = ySet;
        } else {
            ySet.parent = xSet;

            if (ySet.rank == xSet.rank) {
                ySet.rank++;
            }
        }
    }

    /**
     * @return true if, and only if, both values belong to a set and it's the same set.
     */
    public boolean isSameSet(T x, T y) {
        T setRepX = find(x), setRepY = find(y);
        return (setRepX != null && setRepY != null) && Objects.equals(setRepX, setRepY);
    }

    /**
     * @return true if either value is not in a set or both are different sets.
     */
    public boolean isDisjoint(T x, T y) {
        T setRepX = find(x), setRepY = find(y);
        return (setRepX == null || setRepY == null) || !Objects.equals(setRepX, setRepY);
    }

    /**
     * A node in the disjoint set forest.  Each tree in the forest is a disjoint set,
     * where the root of the tree is the set representative.
     */
    private static class Node<T> {
        int rank;
        Node<T> parent;
        T value;

        Node(T value) {
            this.rank = 0;
            this.parent = this;
            this.value = value;
        }
    }
}
