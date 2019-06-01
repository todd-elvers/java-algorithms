package te.interview.prep.data_structures.trie;

import java.util.Arrays;
import java.util.Objects;

// Optimized for memory but can only handle the characters of the alphabet in lowercase
public class OptimizedTrie {
    private static final int ALPHABET_SIZE = 26;
    private Node root;

    public OptimizedTrie() {
        root = new Node();
    }

    public boolean isEmpty() {
        return root.isChildless();
    }

    // Traverse key entirely adding nodes where necessary
    // O(n), where n is length of key
    public void insert(String key, int value) {
        Node current = root;

        for (char c : key.toCharArray()) {
            if (current.getChild(c) == null) {
                current.setChild(c, new Node());
            }

            current = current.getChild(c);
        }

        current.value = value;
    }

    // O(n), where n is length of key
    public Integer find(String key) {
        Node current = root;

        for (char c : key.toCharArray()) {
            if (current.getChild(c) == null) return null;
            current = current.getChild(c);
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
            return current.isChildless();
        }

        Node next = current.getChild(key.charAt(index));
        if (next == null) return false;

        // If `next` node is empty and has no value, remove it from the tree entirely
        boolean isNextNodeChildless = delete(next, key, index + 1);
        if (isNextNodeChildless && next.value == null) {
            current.setChild(key.charAt(index), null);
            return current.isChildless();
        }

        return false;
    }

    private static class Node {
        private Node[] children = new Node[ALPHABET_SIZE];
        Integer value = null;

        void setChild(char c, Node node) {
            children[toIndex(c)] = node;
        }
        Node getChild(char c) { return children[toIndex(c)]; }
        int toIndex(char c) { return c - 'a'; }
        boolean isChildless() { return Arrays.stream(children).noneMatch(Objects::nonNull); }

        // Kept for future debugging purposes
        private void printTrie(Node node, char c, int offset, String prefix) {
            StringBuilder padding = new StringBuilder();
            for(int i = 0; i < offset; i++) padding.append(" ");
            System.out.print(padding.toString() + (c == ' ' ? "*" : c) + (node.value != null ? " (" + prefix + c + ")" : ""));
            prefix += c;
            prefix = prefix.trim();
            for (int i = 0; i < node.children.length; i++) {
                Node child = node.children[i];
                if (child == null) continue;
                char ch = (char) (i + 'a');
                System.out.println();
                printTrie(child, ch, offset + 2, prefix);
            }
        }
    }
}
