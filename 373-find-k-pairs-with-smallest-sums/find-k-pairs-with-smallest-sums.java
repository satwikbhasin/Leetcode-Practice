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
//     }

//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

//         PriorityQueue<Pair> pairPQ = new PriorityQueue<>((a, b) -> (b.sum - a.sum));
//         for (int i = 0; i < nums1.length; i++) {
//             for (int j = 0; j < nums2.length; j++) {
//                 pairPQ.offer(new Pair(nums1[i], nums2[j]));
//                 if (pairPQ.size() > k) {
//                     pairPQ.poll();
//                 }
//             }
//         }

//         List<List<Integer>> sol = new ArrayList<>();
//         int added = 0;
//         while (!pairPQ.isEmpty()) {
//             sol.add(pairPQ.poll().pair);
//             added++;
//         }

//         return sol;
//     }
// }

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->(a[0] - b[0]));
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<Integer, Integer>(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            ans.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < m && !visited.contains(new Pair<Integer, Integer>(i + 1, j))) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(new Pair<Integer, Integer>(i + 1, j));
            }

            if (j + 1 < n && !visited.contains(new Pair<Integer, Integer>(i, j + 1))) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(new Pair<Integer, Integer>(i, j + 1));
            }
        }

        return ans;
    }
}