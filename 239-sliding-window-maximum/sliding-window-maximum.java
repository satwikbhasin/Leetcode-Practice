// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums == null)
//             return null;

//         int totalSlidingWindows = nums.length - k;
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

//         int[] res = new int[totalSlidingWindows + 1];
//         int pqCounter = 0;
//         for (int i = 0; i <= totalSlidingWindows; i++) {
//             for (int j = i; j < i + k; j++) {
//                 pq.add(nums[j]);
//             }
//             res[pqCounter] = pq.poll();
//             pqCounter++;
//             pq.clear();
//         }
//         return res;
//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0] - a[0]));

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];

        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
