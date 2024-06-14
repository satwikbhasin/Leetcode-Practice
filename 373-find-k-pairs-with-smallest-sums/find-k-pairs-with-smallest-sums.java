// class Solution {
//     class Pair {
//         List<Integer> pair;
//         int sum;

//         public Pair(int x, int y) {
//             pair = new ArrayList<>();
//             pair.add(x);
//             pair.add(y);
//             this.sum = x + y;
//         }

//         @Override
//         public boolean equals(Object o) {
//             if (this == o)
//                 return true;
//             if (o == null || getClass() != o.getClass())
//                 return false;
//             Pair pair1 = (Pair) o;
//             return pair.equals(pair1.pair);
//         }

//         @Override
//         public int hashCode() {
//             return Objects.hash(pair);
//         }
//     }

//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

//         PriorityQueue<Pair> pairPQ = new PriorityQueue<>((a, b) -> (b.sum - a.sum));
//         for (int i = 0; i < nums1.length; i++) {
//             for (int j = 0; j < nums2.length; j++) {
//                 Pair curr = new Pair(nums1[i], nums2[j]);
//                 pairPQ.offer(curr);
//                     pairCount.put(curr, 1);
//                     if (pairPQ.size() > k) {
//                         pairPQ.poll();
//                     }

//             }
//         }

//         List<List<Integer>> sol = new ArrayList<>();
//         int added = 0;
//         while (!pairPQ.isEmpty()) {
//             Pair curr = pairPQ.poll();
//                 sol.add(curr.pair);
//                 added++;
//             }
//         }

//     return sol;
// }}

import java.util.*;

class Solution {
    class Pair {
        List<Integer> pair;
        int sum;

        public Pair(int x, int y) {
            pair = new ArrayList<>();
            pair.add(x);
            pair.add(y);
            this.sum = x + y;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        // Generate and maintain k smallest pairs using two pointers
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                Pair currPair = new Pair(nums1[i], nums2[j]);
                // Add current pair to maxHeap if its sum is smaller than the largest sum in
                // maxHeap or maxHeap size is less than k
                if (maxHeap.size() < k || currPair.sum < maxHeap.peek().sum) {
                    maxHeap.offer(currPair);
                    if (maxHeap.size() > k) {
                        maxHeap.poll(); // Remove the pair with the largest sum
                    }
                } else {
                    break; // No need to check further pairs with larger sums
                }
            }
        }

        // Add k smallest pairs to the result list
        while (!maxHeap.isEmpty()) {
            result.add(0, maxHeap.poll().pair); // Add pairs at the beginning to maintain order
        }

        return result;
    }
}
