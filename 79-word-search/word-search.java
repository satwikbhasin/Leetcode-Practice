class Solution {
    int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    char[][] board;
    String word;

    private boolean dfs(StringBuilder currWord, int x, int y, boolean[][] used) {
        currWord.append(board[x][y]);

        if (currWord.toString().equals(word)) {
            return true;
        }

        if (!word.startsWith(currWord.toString())) {
            currWord.deleteCharAt(currWord.length() - 1);
            return false;
        }

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && !used[newX][newY]) {
                used[newX][newY] = true;
                if (dfs(currWord, newX, newY, used)) {
                    return true;
                }
                used[newX][newY] = false;
            }
        }

        currWord.deleteCharAt(currWord.length() - 1);

        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[board.length][board[0].length];
                    used[i][j] = true;
                    if (dfs(new StringBuilder(), i, j, used)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}