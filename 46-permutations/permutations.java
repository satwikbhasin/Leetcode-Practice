class Solution {
    List<List<Integer>> solution;

    private void dfs(int[] nums, List<Integer> currList, boolean[] used) {
        if (currList.size() == nums.length) {
            solution.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                currList.add(nums[i]);
                dfs(nums, currList, used);
                used[i] = false;
                currList.remove(currList.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        solution = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return solution;
        }

        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used);

        return solution;
    }
}