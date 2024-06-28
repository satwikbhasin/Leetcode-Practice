class Solution {
    int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    char[][] board;
    String word;
    int n, m;
    Map<Character, Integer> boardCharCount;

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
        this.n = board.length;
        this.m = board[0].length;
        this.boardCharCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i][j];
                boardCharCount.put(c, boardCharCount.getOrDefault(c, 0) + 1);
            }
        }

        Map<Character, Integer> wordCharCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) + 1);
        }

        for (char c : wordCharCount.keySet()) {
            if (wordCharCount.get(c) > boardCharCount.getOrDefault(c, 0)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char currChar = board[i][j];
                if (currChar == word.charAt(0)) {
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