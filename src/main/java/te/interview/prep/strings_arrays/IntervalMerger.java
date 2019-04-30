package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/merge-intervals/">Problem on leetcode</a>
 */
public class IntervalMerger {

    public int[][] mergeUsingMinHeap(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        sortByStartTimesAscending(intervals);

        PriorityQueue<int[]> minHeapByEndTimes = new PriorityQueue<>(
                Comparator.comparingInt(interval -> interval[1])
        );

        List<int[]> merged = new ArrayList<>();
        for (int[] nextInterval : intervals) {
            if (minHeapByEndTimes.isEmpty()) {
                minHeapByEndTimes.add(nextInterval);
                continue;
            }

            if (nextInterval[0] <= minHeapByEndTimes.peek()[1]) {
                int[] overlappingInterval = minHeapByEndTimes.poll();
                overlappingInterval[1] = Math.max(overlappingInterval[1], nextInterval[1]);
                minHeapByEndTimes.add(overlappingInterval);
            } else {
                // We've merged all we can with the previous min, so store
                // it in our results and add the next interval
                merged.add(minHeapByEndTimes.poll());
                minHeapByEndTimes.add(nextInterval);
            }
        }

        // Add anything leftover in our min-heap
        merged.addAll(minHeapByEndTimes);

        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] mergeUsingTempVariable(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        sortByStartTimesAscending(intervals);

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] mergedInterval = null;
        for (int[] interval : intervals) {
            if (mergedInterval == null) {
                mergedInterval = interval;
                continue;
            }

            // If current interval starts before merged interval ends, merge current interval
            if (interval[0] <= mergedInterval[1]) {
                mergedInterval[1] = Math.max(interval[1], mergedInterval[1]);
            } else {
                mergedIntervals.add(mergedInterval);
                mergedInterval = interval;
            }
        }

        mergedIntervals.add(mergedInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    private void sortByStartTimesAscending(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    }

}
