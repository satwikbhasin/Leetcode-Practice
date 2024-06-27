class Solution {
    List<List<Integer>> solution;

    private void dfs(int[] candidates, int target, List<Integer> currList, int currSum, int candidateIndex) {
        if (currSum == target) {
            solution.add(new ArrayList<>(currList));
            return;
        }

        for (int i = candidateIndex; i < candidates.length; i++) {
            int currCandidate = candidates[i];
            if (currSum + currCandidate <= target) {
                currList.add(currCandidate);
                dfs(candidates, target, currList, currSum + currCandidate, i);
                currList.remove(currList.size() - 1);
            } else {
                break;
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solution = new ArrayList<>();

        if (target == 0) {
            return solution;
        }

        Arrays.sort(candidates);

        dfs(candidates, target, new ArrayList<>(), 0, 0);

        return solution;
    }
}