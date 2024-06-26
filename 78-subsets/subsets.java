class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void dfsBacktrack(int[] nums, int currIndex, List<Integer> currList) {
        result.add(new ArrayList<>(currList));

        for (int i = currIndex; i < nums.length; i++) {
            currList.add(nums[i]);
            dfsBacktrack(nums, i + 1, currList);
            currList.remove(currList.size() - 1);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        dfsBacktrack(nums, 0, new ArrayList<Integer>());
        return result;
    }

}