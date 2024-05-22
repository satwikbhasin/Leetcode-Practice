class Solution {
    public class PointData{
        private int x;
        private int y;
        private double distanceToOrigin;

        public PointData(int x, int y) {
            this.x = x;
            this.y = y;
            this.distanceToOrigin = Math.sqrt(x * x + y * y);
        }

    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointData> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distanceToOrigin, a.distanceToOrigin));
        for (int[] point : points) {
            pq.add(new PointData(point[0], point[1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int pointer = 0;
        while(!pq.isEmpty()){
            PointData point = pq.poll();
            result[pointer][0] = point.x;
            result[pointer][1] = point.y;
            pointer++;
        }

        return result;

    }
}