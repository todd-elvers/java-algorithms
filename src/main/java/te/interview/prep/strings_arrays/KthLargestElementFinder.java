package te.interview.prep.strings_arrays;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Problem on
 * leetcode</a>
 */
public class KthLargestElementFinder {

    public int find(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Looking for kth largest, so using a min heap and polling when we surpass
        // length of k ensures the smallest elements are always removed
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if (minHeap.size() > k) minHeap.poll();
        }

        // By the end we have only k elements in the heap and the smallest one,
        // i.e. the one at the top of the heap, is the k-th largest
        return minHeap.poll();
    }

}
