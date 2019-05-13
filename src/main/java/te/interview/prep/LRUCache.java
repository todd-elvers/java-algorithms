package te.interview.prep;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/lru-cache/">Problem on leetcode</a>
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        moveNodeToHead(cache.get(key));
        return head.value;
    }

    // Move an existing node from wherever it is to the head
    private void moveNodeToHead(Node node) {
        if(node == head) return;

        // If our node isn't the head then it's the tail or somewhere in between
        if (node == tail) {
            truncateTailByOne();
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        setNodeAsHead(node);
    }

    private void truncateTailByOne() {
        tail = tail.prev;
        tail.next = null;
    }

    private void setNodeAsHead(Node node) {
        // Edge case: cache may be empty
        if (head == null) {
            head = tail = node;
        } else {
            // Prepare our node to be the new head
            node.prev = null;
            node.next = head;

            // Push the existing head node down
            head.prev = node;
            head = node;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            moveNodeToHead(cache.get(key).withNewValue(value));
        } else {
            if (cache.size() == capacity) {
                evictLeastRecentlyUsed();
            }
            setNodeAsHead(new Node(key, value));
        }

        cache.put(key, head);
    }

    private void evictLeastRecentlyUsed() {
        cache.remove(tail.key);

        // LRU is either the tail of the list or both the head AND the tail
        if (capacity == 1) {
            head = tail = null;
        } else {
            truncateTailByOne();
        }
    }

    private class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node withNewValue(int value) {
            this.value = value;
            return this;
        }
    }
}
