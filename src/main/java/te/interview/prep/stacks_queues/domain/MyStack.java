package te.interview.prep.stacks_queues.domain;

import te.interview.prep.linked_lists.domain.Node;

import java.util.EmptyStackException;

public class MyStack<T> {
    protected Node<T> top;

    public T pop() {
        if(top == null) throw new EmptyStackException();

        T item = top.data;
        top = top.next;

        return item;
    }

    public void push(T item) {
        Node<T> newTop = new Node<>(item);
        newTop.next = top;
        top = newTop;
    }

    public T peek() {
        if(top == null) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
