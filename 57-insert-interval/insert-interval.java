// O(n) Time, O(1) Space
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;

        int left = 0;
        int right = intervals.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][1] < newInterval[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        while (i < left) {
            merged.add(intervals[i]);
            i++;
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add merged interval
        merged.add(newInterval);

        // add all unaffected by newInterval after it's ending
        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[merged.size()][]);

    }
}

// O(n) Time, O(1) Space
// class Solution {
// public int[][] insert(int[][] intervals, int[] newInterval) {
// List<int[]> merged = new ArrayList<>();
// int i = 0;

// // add all unaffected by newInterval before it's starting
// while (i < intervals.length && intervals[i][1] < newInterval[0]) {
// merged.add(intervals[i]);
// i++;
// }

// // merge all that are affected by newInterval (start before newInterval's end
// and end after newInterval's start)
// while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
// newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
// newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
// i++;
// }

// // add merged interval
// merged.add(newInterval);

// // add all unaffected by newInterval after it's ending
// while (i < intervals.length) {
// merged.add(intervals[i]);
// i++;
// }

// return merged.toArray(new int[merged.size()][]);

// }
// }