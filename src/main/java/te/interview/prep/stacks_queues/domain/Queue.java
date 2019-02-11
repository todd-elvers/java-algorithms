package te.interview.prep.stacks_queues.domain;

public interface Queue<T> {

    void add(T item);

    T remove();

    T peek();

    boolean isEmpty();

}
