class Solution {
    int totalCount;

    private void dfs(int n, int currRow, HashSet<Integer> colsOccupied,
            HashSet<Integer> dOccupied,
            HashSet<Integer> adOccupied) {

        if (currRow == n) {
            totalCount++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d = currRow - col;
            int ad = currRow + col;
            if (colsOccupied.contains(col) || dOccupied.contains(d) || adOccupied.contains(ad)) {
                continue;
            }

            colsOccupied.add(col);
            dOccupied.add(d);
            adOccupied.add(ad);

            dfs(n, currRow + 1, colsOccupied, dOccupied, adOccupied);

            colsOccupied.remove(col);
            dOccupied.remove(d);
            adOccupied.remove(ad);
        }

    }

    public int totalNQueens(int n) {

        if (n < 1) {
            return 0;
        }

        dfs(n, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());

        return totalCount;
    }
}