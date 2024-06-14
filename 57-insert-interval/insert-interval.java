class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;

        // Add all before newIntervals's position
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // Add newIntervals at it's position and merge if necessary
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);

        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);

    }
}