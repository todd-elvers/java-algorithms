package te.interview.prep;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @see <a href="https://leetcode.com/problems/meeting-rooms/">Problem on leetcode</a>
 */
public class MeetingAttendingDeterminer {

    public boolean canAttendMeetings(int[][] meetingTimes) {
        if(meetingTimes == null || meetingTimes.length == 0) return true;

        sortByStartTimesAscending(meetingTimes);

        int mostRecentMeetingEndTime = -1;
        for(int[] meetingTime : meetingTimes) {
            // Cannot attend current meeting if most recent meeting hasn't ended yet
            if(mostRecentMeetingEndTime > meetingTime[0]) return false;

            mostRecentMeetingEndTime = meetingTime[1];
        }

        return true;
    }

    private void sortByStartTimesAscending(int[][] meetingTimes) {
        Arrays.sort(meetingTimes, Comparator.comparingInt(meetingTime -> meetingTime[0]));
    }
}
