class Solution {

    private int slidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> windowCount = new HashMap<>();

        int count = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int newNum = nums[right];
            windowCount.put(newNum, windowCount.getOrDefault(newNum, 0) + 1);
            while (windowCount.size() > k) {
                int leftNum = nums[left];
                windowCount.put(leftNum, windowCount.get(leftNum) - 1);
                if (windowCount.get(leftNum) == 0) {
                    windowCount.remove(leftNum);
                }
                left++;
            }
            count += (right - left + 1);
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }
}