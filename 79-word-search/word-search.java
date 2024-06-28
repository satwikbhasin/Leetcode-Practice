class Solution {
    int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    char[][] board;
    String word;

    private boolean dfs(int index, int x, int y, boolean[][] used) {

        if (index == word.length()) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && !used[newX][newY]
                    && board[newX][newY] == word.charAt(index)) {
                used[newX][newY] = true;
                if (dfs(index + 1, newX, newY, used)) {
                    return true;
                }
                used[newX][newY] = false;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length * board[0].length < word.length()) {
            return false;
        }

        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {

                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j] = true;

                    if (dfs(1, i, j, used)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}