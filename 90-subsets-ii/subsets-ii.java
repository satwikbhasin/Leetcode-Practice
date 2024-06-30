class Solution {
    List<List<Integer>> result;
    HashSet<List<Integer>> sets;

    private void dfs(int[] nums, int idx, ArrayList<Integer> subset) {
        if (!sets.contains(subset)) {
            List<Integer> curr = new ArrayList<>(subset);
            result.add(curr);
            sets.add(curr);
        }

        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        sets = new HashSet<>();
        dfs(nums, 0, new ArrayList<Integer>());
        return result;
    }
}