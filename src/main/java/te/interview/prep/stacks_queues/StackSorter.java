package te.interview.prep.stacks_queues;

public class StackSorter {

    public BasicStack<Integer> sort(BasicStack<Integer> unsorted) {
        if(unsorted == null || unsorted.isEmpty()) return unsorted;

        BasicStack<Integer> sorted = new BasicStack<>();
        sorted.push(unsorted.pop());

        while(!unsorted.isEmpty()) {
            Integer item = unsorted.pop();

            // If we encounter an item that can't simply be added to the end of
            // `sorted` then pop off enough values from `sorted` until it can
            while(!sorted.isEmpty() && item > sorted.peek()) {
                unsorted.push(sorted.pop());
            }

            sorted.push(item);
        }


        return sorted;
    }

}
