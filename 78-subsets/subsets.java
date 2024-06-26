class Solution {
    List<List<Integer>> result;

    private void dfs(int[] nums, int idx, ArrayList<Integer> subset) {
        result.add(new ArrayList<>(subset));

        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>());
        return result;
    }
}