class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderUsedFor = new PriorityQueue<>();
        int furthestBuilding = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            int heightDiff = heights[i + 1] - heights[i];
            if (heightDiff > 0) {
                ladderUsedFor.add(heightDiff);

                if (ladderUsedFor.size() > ladders)
                    bricks -= ladderUsedFor.poll();

                if (bricks < 0)
                    return i;
            }
            furthestBuilding = i + 1;
        }
        return furthestBuilding;
    }
}
