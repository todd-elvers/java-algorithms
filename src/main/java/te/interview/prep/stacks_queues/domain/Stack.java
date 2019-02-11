package te.interview.prep.stacks_queues.domain;

public interface Stack<T> {

    T pop();

    void push(T item);

    T peek();

    boolean isEmpty();

}
