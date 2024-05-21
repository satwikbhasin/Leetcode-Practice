import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<Integer> roomFreeTime = new PriorityQueue<>();
        roomFreeTime.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= roomFreeTime.peek()) {
                roomFreeTime.poll();
            }
            roomFreeTime.add(intervals[i][1]);
        }

        return roomFreeTime.size();
    }
}
