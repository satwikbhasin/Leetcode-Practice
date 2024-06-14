// // O(n) Time, O(log N) Space
// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         if (points == null || points.length == 0)
//             return 0;

//         Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

//         int minArrows = 1;
//         int startX = points[0][0];
//         int endX = points[0][1];

//         for (int i = 1; i < points.length; i++) {
//             if (points[i][0] > endX) {
//                 minArrows++;
//                 startX = points[i][0];
//                 endX = points[i][1];
//             }
//         }

//         return minArrows;
//     }
// }

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];

            // If the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }
}