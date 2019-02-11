package te.interview.prep.stacks_queues.domain;

import te.interview.prep.linked_lists.domain.Node;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> node = new Node<>(item);

        // Edge case: when queue is empty we cannot update last's next field
        if(last != null) {
            last.next = node;
        }

        last = node;

        // Edge case: when queue is empty the first element is also the last
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        // Edge case: removing from an already empty queue
        if(first == null) throw new NoSuchElementException();

        T item = first.data;

        first = first.next;

        // Edge case: removing last element in the list
        if(first == null) {
            last = null;
        }

        return item;
    }

    public T peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
