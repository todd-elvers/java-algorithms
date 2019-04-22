package te.interview.prep.stacks_queues;

/**
 * @see <a href="https://leetcode.com/problems/max-stack/">Problem on leetcode</a>
 */
public class MaxStack {

    private Node top;

    public void push(int newData) {
        Node newTop = new Node(newData, findMaxOf(top, newData));

        if(top == null) {
            top = newTop;   // Edge case: pushing onto an empty stack
        } else {
            newTop.next = top;
            top.prev = newTop;
            top = newTop;
        }
    }

    private int findMaxOf(Node node, int data) {
        return (node == null) ? data : Math.max(data, node.max);
    }

    public int pop() {
        int topData = top.data;

        if(top.next == null) {
            top = null;     // Edge case: popping last element from stack
        } else {
            top = top.next;
            top.prev = null;
        }

        return topData;
    }

    public int top() {
        return top.data;
    }

    public int peekMax() {
        return top.max;
    }

    public int popMax() {
        // Edge case: top element is max element (also simplest case)
        if(top.data == top.max) return pop();

        int oldMax = top.max;
        Node node = findNodePrecedingValue(oldMax);
        removeNextNode(node);
        updateMaxForAllNodesPrecedingRemovedNode(node);

        return oldMax;
    }

    private Node findNodePrecedingValue(int value) {
        Node node = top;
        while(node.next.data != value) {
            node = node.next;
        }
        return node;
    }

    private void removeNextNode(Node node) {
        if(node.next.next == null) {        // We're at second to last element in stack
            node.next = null;
        } else {                            // We're somewhere in the middle of the stack
            node.next = node.next.next;
            node.next.prev = node;
        }
    }

    private void updateMaxForAllNodesPrecedingRemovedNode(Node node) {
        while(node != null) {
            node.max = findMaxOf(node.next, node.data);
            node = node.prev;
        }
    }

    static class Node {
        int data, max;
        Node next, prev;

        Node(int data, int max) {
            this.data = data;
            this.max = max;
        }
    }

}
