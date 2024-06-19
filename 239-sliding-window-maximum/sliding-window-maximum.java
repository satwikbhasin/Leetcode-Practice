// O(n) Time, O(k) Space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int totalWindows = nums.length - k + 1;

        int[] result = new int[totalWindows];
        int ptr = 0;

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        result[ptr++] = nums[deque.peekFirst()];

        for (int right = k; right < nums.length; right++) {
            int left = right - k;

            if (deque.peekFirst() == left) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(right);
            result[ptr++] = nums[deque.peekFirst()];
        }

        return result;

    }
}

// O(nlogk) Time, O(k) Space
// class Solution {
// public int[] maxSlidingWindow(int[] nums, int k) {
// PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
// int totalWindows = nums.length - k + 1;

// int[] result = new int[totalWindows];
// int ptr = 0;

// for (int i = 0; i < k; i++) {
// pq.offer(new int[] { nums[i], i });
// }

// result[ptr++] = pq.peek()[0];

// for (int right = k; right < nums.length; right++) {
// int left = right - k;
// pq.offer(new int[] { nums[right], right });

// while (pq.peek()[1] <= left) {
// pq.poll();
// }

// result[ptr++] = pq.peek()[0];
// }

// return result;

// }
// }