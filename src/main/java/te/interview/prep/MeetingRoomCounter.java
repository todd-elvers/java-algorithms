package te.interview.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/meeting-rooms-ii/">Problem on leetcode</a>
 */
public class MeetingRoomCounter {

    public int minMeetingRooms(int[][] meetingTimes) {
        if (meetingTimes == null || meetingTimes.length == 0) return 0;

        sortByStartTime(meetingTimes);

        PriorityQueue<Integer> meetingEndTimes = new PriorityQueue<>();
        for (int[] nextMeetingTime : meetingTimes) {
            if (canReuseAnExistingMeetingRoom(meetingEndTimes, nextMeetingTime[0])) {
                meetingEndTimes.poll();
            }

            meetingEndTimes.add(nextMeetingTime[1]);
        }

        return meetingEndTimes.size();
    }

    /**
     * If the next meeting to start will start on or after the latest meeting to end then we can
     * reuse the latest meeting to end's room.
     *
     * @return true if the room of the latest meeting to end
     */
    private boolean canReuseAnExistingMeetingRoom(PriorityQueue<Integer> meetingEndTimes, int nextMeetingStartTime) {
        return !meetingEndTimes.isEmpty() && meetingEndTimes.peek() <= nextMeetingStartTime;
    }

    private void sortByStartTime(int[][] meetingTimes) {
        Arrays.sort(meetingTimes, Comparator.comparingInt(meetingTime -> meetingTime[0]));
    }
}
