package te.interview.prep.linked_lists.domain;

public class Node<T> {
    public Node<T> next = null;
    public T data;

    public static <T> Node<T> create(T... elements) {
        if(elements.length == 0) return null;

        Node<T> head = new Node<>(elements[0]);
        Node<T> n = head;
        for(int i = 1; i < elements.length; i++) {
            n.next = new Node<>(elements[i]);
            n = n.next;
        }

        return head;
    }

    public Node(T data) {
        this.data = data;
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
