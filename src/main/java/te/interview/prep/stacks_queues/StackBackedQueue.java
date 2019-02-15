package te.interview.prep.stacks_queues;

import java.util.NoSuchElementException;

import te.interview.prep.stacks_queues.domain.Queue;

/**
 * 3.4
 *
 * Naive approach - swap first stack to second stack on remove()s & peek()s, then back again
 * Optimized approach - same as above but lazily perform the swap from second back to first
 */
public class StackBackedQueue<T> implements Queue<T> {
    private BasicStack<T> first, last;

    StackBackedQueue() {
        first = new BasicStack<>();
        last = new BasicStack<>();
    }

    @Override
    public void add(T item) {
        if(!last.isEmpty()) moveLastToFirst();
        first.push(item);
    }

    @Override
    public T remove() {
        throwIfConstraintViolation();

        if(last.isEmpty()) moveFirstToLast();

        return last.pop();
    }

    protected void moveFirstToLast() {
        while(!first.isEmpty()) last.push(first.pop());
    }

    protected void moveLastToFirst() {
        while(!last.isEmpty()) first.push(last.pop());
    }

    @Override
    public T peek() {
        throwIfConstraintViolation();

        if(last.isEmpty()) moveFirstToLast();

        return last.peek();
    }

    private void throwIfConstraintViolation() {
        if(isEmpty()) throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return first.isEmpty() && last.isEmpty();
    }
}
