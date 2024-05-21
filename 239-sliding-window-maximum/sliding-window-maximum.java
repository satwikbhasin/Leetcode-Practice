import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        Map<Integer, Integer> outOfWindow = new HashMap<>();

        // Initialize the priority queue with the first k elements
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        res[0] = pq.peek()[0];

        for (int i = k; i < n; i++) {
            // Add new element to the priority queue
            pq.offer(new int[]{nums[i], i});

            // Remove elements that are out of the window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // Store the current max
            res[i - k + 1] = pq.peek()[0];
        }

        return res;
    }
}
