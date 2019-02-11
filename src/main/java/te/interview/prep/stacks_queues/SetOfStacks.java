package te.interview.prep.stacks_queues;

import java.util.EmptyStackException;

import te.interview.prep.stacks_queues.domain.Stack;

/**
 * 3.3
 */
public class SetOfStacks<T> implements Stack<T> {
    private int threshold;
    private CountStack<CountStack<T>> stacks;

    SetOfStacks(int threshold) {
        this.threshold = threshold;
        this.stacks = new CountStack<>();
    }

    @Override
    public T pop() {
        if (stacks.isEmpty()) throw new EmptyStackException();

        T item = stacks.peek().pop();

        if (stacks.peek().isEmpty()) {
            stacks.pop();
        }

        return item;
    }

    public T popAt(int index) {
        if (stacks.isEmpty()) throw new EmptyStackException();
        if (stacks.size - 1 < index) throw new IndexOutOfBoundsException();

        CountStack<CountStack<T>> temp = popStacks(index);
        T item = pop();
        pushStacks(temp);

        return item;
    }

    private CountStack<CountStack<T>> popStacks(int numStacksToPop) {
        CountStack<CountStack<T>> temp = new CountStack<>();
        for (int i = 0; i < numStacksToPop; i++){
            temp.push(stacks.pop());
        }
        return temp;
    }

    private void pushStacks(CountStack<CountStack<T>> pushOntoStacks) {
        while(!pushOntoStacks.isEmpty()) {
            stacks.push(pushOntoStacks.pop());
        }
    }

    @Override
    public void push(T item) {
        if (stacks.isEmpty() || stacks.peek().size == threshold) {
            stacks.push(new CountStack<>());
        }

        stacks.peek().push(item);
    }

    @Override
    public T peek() {
        if (stacks.isEmpty()) throw new EmptyStackException();
        return stacks.peek().peek();
    }

    public int getNumStacks() {
        return stacks.size;
    }

    @Override
    public boolean isEmpty() {
        return stacks.isEmpty();
    }
}

class CountStack<T> extends BasicStack<T> {
    int size = 0;

    @Override
    public T pop() {
        size--;
        return super.pop();
    }

    @Override
    public void push(T item) {
        size++;
        super.push(item);
    }

    @Override
    public String toString() {
        return "CountStack(" + size + ")";
    }
}