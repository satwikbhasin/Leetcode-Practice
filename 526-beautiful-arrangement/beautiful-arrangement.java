class Solution {
    private int dfs(int n, int[] current, int currNumber) {
        if (currNumber == n) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (current[i - 1] == 0 && (i % (currNumber + 1) == 0 || (currNumber + 1) % i == 0)) {
                current[i - 1] = 1;
                count += dfs(n, current, currNumber + 1);
                current[i - 1] = 0;
            }
        }

        return count;
    }

    public int countArrangement(int n) {
        
        return dfs(n, new int[n + 1], 0);
    }
}