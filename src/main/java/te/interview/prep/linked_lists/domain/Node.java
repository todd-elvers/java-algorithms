package te.interview.prep.linked_lists.domain;

public class Node {
    public Node next = null;
    public int data;

    public static Node create(int... integers) {
        if(integers.length == 0) return null;

        Node head = new Node(integers[0]);
        Node n = head;
        for(int i = 1, j = 1; i < integers.length; i++) {
            n.next = new Node(integers[i]);
            n = n.next;
        }

        return head;
    }

    public Node(int data) {
        this.data = data;
    }

    void appendToTail(int d) {
        Node n = this;

        // Traverse to end of list
        while(n.next != null) {
            n = n.next;
        }

        // Append to tail
        n.next = new Node(d);
    }

    Node deleteNode(int dataToDelete) {
        Node n = this;

        if(n.data == dataToDelete) {
            return this.next;
        }

        while(n.next != null) {
            if(n.next.data == dataToDelete) {
                n.next = n.next.next;
                return this;
            }

            n = n.next;
        }

        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = this;

        while(n.next != null) {
            sb.append(n.data);
            sb.append(" -> ");
            n = n.next;
        }

        sb.append(n.data);

        return sb.toString();
    }

}
