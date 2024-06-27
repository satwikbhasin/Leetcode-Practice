class Solution {
    List<List<Integer>> solution;
    HashMap<Integer, HashSet<Integer>> seen;

    // private String

    private void dfs(int range, int reqLength, List<Integer> currList, int currLength, int idx) {
        if (currLength == reqLength) {
            solution.add(new ArrayList<>(currList));
            return;
        }

        for (int i = idx; i <= range; i++) {
            currList.add(i);
            dfs(range, reqLength, currList, currLength + 1, i + 1);
            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        solution = new ArrayList<>();
        seen = new HashMap<>();

        if (k > n) {
            return solution;
        }

        dfs(n, k, new ArrayList<>(), 0, 1);

        return solution;
    }
}