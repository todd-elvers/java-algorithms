package te.interview.prep.stacks_queues;

public class StackSorter {

    // My solution
    public BasicStack<Integer> sort(BasicStack<Integer> unsorted) {
        if(unsorted == null || unsorted.isEmpty()) return unsorted;

        BasicStack<Integer> sorted = new BasicStack<>();
        sorted.push(unsorted.pop());

        //TODO: Review & figure out why this works - it's better than my solution or the book's
        while(!unsorted.isEmpty()) {
            Integer item = unsorted.pop();

            while(!sorted.isEmpty() && item > sorted.peek()) {
                unsorted.push(sorted.pop());
            }

            sorted.push(item);
        }


        return sorted;
    }

    // Book solution
//    public BasicStack<Integer> sort(BasicStack<Integer> input) {
//        if(input == null || input.isEmpty()) return input;
//
//        BasicStack<Integer> temp = new BasicStack<>();
//
//        while(!input.isEmpty()) {
//            Integer item = input.pop();
//
//            while(!temp.isEmpty() && temp.peek() > item) {
//                input.push(temp.pop());
//            }
//
//            temp.push(item);
//        }
//
//        while(!temp.isEmpty()) {
//            input.push(temp.pop());
//        }
//
//        return input;
//    }

}
