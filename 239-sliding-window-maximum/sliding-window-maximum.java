class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        int totalWindows = nums.length - k + 1;

        int[] result = new int[totalWindows];
        int ptr = 0;

        for (int i = 0; i < k; i++) {
            pq.offer(new int[] { nums[i], i });
        }

        result[ptr++] = pq.peek()[0];

        for (int right = k; right < nums.length; right++) {
            int left = right - k;
            pq.offer(new int[] { nums[right], right });

            while (pq.peek()[1] <= left) {
                pq.poll();
            }

            result[ptr++] = pq.peek()[0];
        }

        return result;

    }
}