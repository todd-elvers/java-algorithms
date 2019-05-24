package te.interview.prep.algorithms_datastructures;

import java.util.HashMap;
import java.util.Map;

// Uses more memory but can handle any character code
// Treats uppercase and lowercase differently
public class GeneralTrie {
    private Node root;

    public GeneralTrie() {
        root = new Node();
    }

    public boolean isEmpty() {
        return root.children.size() == 0;
    }

    // Traverse key entirely adding nodes where necessary
    // O(n), where n is length of key
    public void insert(String key, int value) {
        Node current = root;

        for (char c : key.toCharArray()) {
            current = current.children.computeIfAbsent(c, character -> new Node());
        }

        current.value = value;
    }

    // O(n), where n is length of key
    public Integer find(String key) {
        Node current = root;

        for (char c : key.toCharArray()) {
            Node node = current.children.get(c);
            if (node == null) return null;
            current = node;
        }

        return current.value;
    }

    public void delete(String key) {
        delete(root, key, 0);
    }

    // Walk down to the node holding the value for `key` and nullify it
    // While you walk back up, remove any nodes that have no children
    private boolean delete(Node current, String key, int index) {
        // Base case: `current` should be the node that contains the value for `key`
        if (index == key.length()) {
            if (current.value == null) return false;
            current.value = null;
            return current.children.isEmpty();
        }

        Node next = current.children.get(key.charAt(index));

        // Some or all of `key` is not present in our trie
        if (next == null) return false;

        // Keep walking down the letters in `key`
        boolean isNextNodeEmpty = delete(next, key, index + 1);

        // If `next` node is empty and has no value, remove it from the tree
        if (isNextNodeEmpty && next.value == null) {
            current.children.remove(key.charAt(index));
            return current.children.isEmpty();
        }

        return false;
    }

    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        Integer value = null;
    }
}
