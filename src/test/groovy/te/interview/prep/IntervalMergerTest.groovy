package te.interview.prep

import spock.lang.Specification
import spock.lang.Subject

class IntervalMergerTest extends Specification {

    @Subject
    IntervalMerger intervalMerger = []

    def "can properly merge intervals that overlap"(int[][] intervals, int[][] merged) {
        expect:
            intervalMerger.mergeUsingMinHeap(intervals) == merged
            intervalMerger.mergeUsingTempVariable(intervals) == merged

        where:
            intervals                                                || merged
            [[1, 3], [2, 6], [8, 10], [15, 18]]                      || [[1, 6], [8, 10], [15, 18]]
            [[1, 3], [3, 6], [8, 10], [15, 18]]                      || [[1, 6], [8, 10], [15, 18]]
            [[1, 4], [4, 5]]                                         || [[1, 5]]
            [[2, 3], [2, 2], [3, 3], [1, 3], [5, 7], [2, 2], [4, 6]] || [[1, 3], [4, 7]]
    }

}
