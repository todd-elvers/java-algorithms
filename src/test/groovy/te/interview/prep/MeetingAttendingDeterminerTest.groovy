package te.interview.prep

import spock.lang.Specification
import spock.lang.Subject
import te.interview.prep.MeetingAttendingDeterminer

class MeetingAttendingDeterminerTest extends Specification {

    @Subject
    MeetingAttendingDeterminer meetingAttendingDeterminer = []

    def "can determine if all meetings can be attended or not"(int[][] meetingTimes, boolean canAttendAll) {
        expect:
            meetingAttendingDeterminer.canAttendMeetings(meetingTimes) == canAttendAll

        where:
            meetingTimes                                            || canAttendAll
            null                                                    || true
            []                                                      || true
            [[7, 10], [2, 4]]                                       || true
            [[2, 11], [6, 16], [11, 16]]                            || false
            [[0, 30], [2, 4], [5, 8], [12, 13], [13, 30], [13, 14]] || false
            [[9, 10], [4, 9], [4, 17]]                              || false
            [[2, 11], [6, 16], [11, 16]]                            || false
            [[6, 15], [13, 20], [6, 17]]                            || false
    }

}
