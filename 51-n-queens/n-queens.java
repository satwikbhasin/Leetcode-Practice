class Solution {
    List<List<String>> solution;

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char[] row : state) {
            sb.setLength(0);
            for (char cell : row) {
                sb.append(cell);
            }
            board.add(sb.toString());
        }

        return board;
    }

    private void dfs(int n, int currRow, HashSet<Integer> colsOccupied,
            HashSet<Integer> dOccupied,
            HashSet<Integer> adOccupied, char[][] state) {

        if (currRow == n) {
            solution.add(createBoard(state));
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
            state[currRow][col] = 'Q';

            dfs(n, currRow + 1, colsOccupied, dOccupied, adOccupied, state);

            colsOccupied.remove(col);
            dOccupied.remove(d);
            adOccupied.remove(ad);
            state[currRow][col] = '.';
        }

    }

    public List<List<String>> solveNQueens(int n) {
        solution = new ArrayList<>();

        if (n < 1) {
            return solution;
        }

        char[][] emptyBoard = new char[n][n];

        for (char[] row : emptyBoard) {
            Arrays.fill(row, '.');
        }

        dfs(n, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), emptyBoard);

        return solution;
    }
}