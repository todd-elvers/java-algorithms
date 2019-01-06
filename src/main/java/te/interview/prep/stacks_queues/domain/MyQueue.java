package te.interview.prep.stacks_queues.domain;

import te.interview.prep.linked_lists.domain.Node;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private Node<T> front;
    private Node<T> back;

    public void add(T item) {
        Node<T> node = new Node<>(item);

        // Edge case: adding first element to queue
        if(back == null) {
            back = node;
        } else {
            back.next = node;
            back = node;
        }

        // Edge case: adding first element to queue
        if(front == null) {
            front = back;
        }
    }

    public T remove() {
        if(front == null) throw new NoSuchElementException();

        T item = front.data;

        // Edge case
        boolean isRemovingLastElement = (front.next == null);
        if(isRemovingLastElement) {
            front = null;
            back = null;
        } else {
            front = front.next;
        }

        return item;
    }

    public T peek() {
        if(front == null) throw new NoSuchElementException();

        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
