class Solution {
    List<List<Integer>> solution;

    private void dfs(int range, int reqLength, List<Integer> currList, int start) {
        if (currList.size() == reqLength) {
            solution.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i <= range; i++) {
            currList.add(i);
            dfs(range, reqLength, currList, i + 1);
            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        solution = new ArrayList<>();

        if (k > n) {
            return solution;
        }

        dfs(n, k, new ArrayList<>(), 1);

        return solution;
    }
}