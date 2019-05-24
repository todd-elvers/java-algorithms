package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/add-and-search-word-data-structure-design/">Problem
 * on leetcode</a>
 */
public class SearchableDictionary {
    private Node root;

    public SearchableDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;

        for (char c : word.toCharArray()) {
            Node child = current.getChild(c);
            child = (child == null) ? current.setChild(c, new Node()) : child;
            current = child;
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node current, String word, int index) {
        if (index == word.length()) return current.isWord;

        char c = word.charAt(index);
        if (c == '.') {
            for (Node next : current.children) {
                if (next != null && search(next, word, index + 1)) return true;
            }
            return false;
        } else {
            Node next = current.getChild(c);
            if (next == null) return false;
            return search(next, word, index + 1);
        }
    }

    private static class Node {
        Node[] children = new Node[26];
        boolean isWord;

        Node getChild(char c) {
            return children[toIndex(c)];
        }

        Node setChild(char c, Node child) {
            children[toIndex(c)] = child;
            return child;
        }

        private int toIndex(char c) { return c - 'a'; }
    }

}
