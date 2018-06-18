package te.interview.prep.linked_lists.domain;

public class LinkedListNode {
    public LinkedListNode next = null;
    public int data;

    public static LinkedListNode create(int... integers) {
        if(integers.length == 0) return null;

        LinkedListNode head = new LinkedListNode(integers[0]);
        LinkedListNode n = head;
        for(int i = 1, j = 1; i < integers.length; i++) {
            n.next = new LinkedListNode(integers[i]);
            n = n.next;
        }

        return head;
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode n = this;

        while(n.next != null) {
            sb.append(n.data);
            sb.append(" -> ");
            n = n.next;
        }

        sb.append(n.data);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
}
