class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int currNumber = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int total = currNumber + nums[left] + nums[right];

                if (total == 0) {
                    results.add(Arrays.asList(currNumber, nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right - 1 && nums[right + 1] == nums[right]) {
                        right--;
                    }
                } else if (total > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return results;
    }
}