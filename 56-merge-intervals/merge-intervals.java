// O(n * log n) Time, O(n) Space
class Solution {
    private boolean isOverlapping(int[] first, int[] second) {
        return first[1] >= second[0];
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> sol = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (isOverlapping(new int[] { min, max }, currInterval)) {
                min = Math.min(min, currInterval[0]);
                max = Math.max(max, currInterval[1]);
            } else {
                sol.add(new int[] { min, max });
                min = currInterval[0];
                max = currInterval[1];
            }
        }

        sol.add(new int[] { min, max });

        return sol.toArray(new int[sol.size()][]);
    }
}