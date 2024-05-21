class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCounts = new int[n];
        PriorityQueue<Integer> unusedRooms = new PriorityQueue<>();
        PriorityQueue<int[]> usedRooms = new PriorityQueue<>((a, b) -> a[1] != b[1] ? (a[1] - b[1]) : (a[0] - b[0]));

        for (int i = 0; i < n; i++) {
            unusedRooms.add(i);
        }

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[1] <= start) {
                int room = usedRooms.poll()[0];
                unusedRooms.add(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.add(new int[] { room, end });
                meetingCounts[room]++;
            } else {
                int room = usedRooms.peek()[0];
                int waitTime = usedRooms.poll()[1];
                usedRooms.add(new int[] { room, end - start + waitTime});
                meetingCounts[room]++;
            }
        }

        int maxMeetingCount = 0;
        int maxMeetingRoom = 0;
        for (int i = 0; i < meetingCounts.length; i++) {
            if (meetingCounts[i] > maxMeetingCount) {
                maxMeetingCount = meetingCounts[i];
                maxMeetingRoom = i;
            }
        }

        return maxMeetingRoom;
    }
}