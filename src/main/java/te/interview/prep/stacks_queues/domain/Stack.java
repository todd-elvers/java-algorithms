package te.interview.prep.stacks_queues.domain;

public interface Stack<T> {

    T pop();

    void push(T item);

    default void pushAll(T... items) {
        for(T item : items) {
            push(item);
        }
    }

    T peek();

    boolean isEmpty();

}
