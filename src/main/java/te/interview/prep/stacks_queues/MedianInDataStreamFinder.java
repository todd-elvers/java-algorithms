package te.interview.prep.stacks_queues;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/find-median-from-data-stream/">Problem on
 * leetcode</a>
 */
public class MedianInDataStreamFinder {
    private PriorityQueue<Integer> higher;  // Min-heap for the larger half of numbers
    private PriorityQueue<Integer> lower;   // Max-heap for the smaller half of numbers

    // Heap goal: always add to the max-heap, then try to balance the heaps.
    // In the worst case, the max-heap may contain one more than the min-heap.
    public MedianInDataStreamFinder() {
        this.higher = new PriorityQueue<>();
        this.lower = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
    }

    public void addNum(int num) {
        // Add the next number to the lower-half of numbers, then move the largest
        // of the smaller numbers to the higher-half of numbers
        lower.add(num);
        higher.add(lower.poll());

        // Try to maintain balanced heaps
        if (lower.size() < higher.size()) {
            lower.add(higher.poll());
        }
    }

    public double findMedian() {
        if (lower.size() > higher.size()) {
            return lower.peek();
        } else {
            return (lower.peek() + higher.peek()) * 0.5d;
        }
    }

}
