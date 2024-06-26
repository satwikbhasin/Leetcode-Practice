class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void dfsBacktrack(int[] nums, int currIndex, List<Integer> currList, int currLimit) {
        if (currList.size() == currLimit) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = currIndex; i < nums.length; i++) {
            currList.add(nums[i]);
            dfsBacktrack(nums, i + 1, currList, currLimit);
            currList.remove(currList.size() - 1);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            dfsBacktrack(nums, 0, new ArrayList<Integer>(), i);
        }
        return result;
    }

}