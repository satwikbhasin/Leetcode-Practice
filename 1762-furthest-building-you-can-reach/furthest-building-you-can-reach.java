// class Solution {
//     public int furthestBuilding(int[] heights, int bricks, int ladders) {
//         PriorityQueue<Integer> ladderUsedFor = new PriorityQueue<>();
//         int furthestBuilding = 0;

//         for (int i = 0; i < heights.length - 1; i++) {
//             int heightDiff = heights[i] - heights[i + 1];
//             if (heightDiff < 0) {
//                 if (ladders > 0) {
//                     ladders--;
//                     ladderUsedFor.add(heightDiff);
//                     furthestBuilding++;
//                 } else if (ladders == 0) {
//                     if (!ladderUsedFor.isEmpty() && heightDiff > ladderUsedFor.peek()
//                             && ladderUsedFor.peek() <= bricks) {
//                         bricks -= ladderUsedFor.poll();
//                         ladderUsedFor.add(heightDiff);
//                         furthestBuilding++;
//                     } else {
//                         if (bricks - heightDiff >= 0) {
//                             bricks -= heightDiff;
//                             furthestBuilding++;
//                         } else
//                             break;
//                     }
//                 }
//             } else {
//                 furthestBuilding++;
//             }
//         }
//         return furthestBuilding;
//     }
// }

import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderUsedFor = new PriorityQueue<>();
        int furthestBuilding = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            int heightDiff = heights[i + 1] - heights[i];
            if (heightDiff > 0) {
                ladderUsedFor.add(heightDiff);
                
                if (ladderUsedFor.size() > ladders) {
                    bricks -= ladderUsedFor.poll();
                }

                if (bricks < 0) {
                    return furthestBuilding;
                }
            }
            furthestBuilding = i + 1;
        }

        return furthestBuilding;
    }
}
