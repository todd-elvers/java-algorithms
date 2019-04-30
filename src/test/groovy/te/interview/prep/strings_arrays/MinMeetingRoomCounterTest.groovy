package te.interview.prep.strings_arrays

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.strings_arrays.MinMeetingRoomCounter

class MinMeetingRoomCounterTest extends Specification {

    @Subject
    MinMeetingRoomCounter minMeetingRoomCounter = []

    def "can determine the minimum number of meeting rooms required"(int[][] meetingTimes, int minimumMeetingRoomCount) {
        expect:
            minMeetingRoomCounter.count(meetingTimes) == minimumMeetingRoomCount

        where:
            meetingTimes                                                   || minimumMeetingRoomCount
            null                                                    || 0
            []                                                      || 0
            [[2, 11], [6, 16], [11, 16]]                            || 2
            [[0, 30], [2, 4], [5, 8], [12, 13], [13, 30], [13, 14]] || 3
            [[9, 10], [4, 9], [4, 17]]                              || 2
            [[2, 11], [6, 16], [11, 16]]                            || 2
            [[6, 15], [13, 20], [6, 17]]                            || 3
    }

    def "min heap implemented via PriorityQueue works as expected"() {
        given:
            PriorityQueue<Integer> minHeap = new PriorityQueue<>()

        when:
            minHeap.add(12)
            minHeap.add(13)
            minHeap.add(16)
            minHeap.add(8)
            minHeap.add(9)

        then:
            minHeap.peek() == 8
            minHeap.poll() == 8
            minHeap.peek() == 9
    }
}
