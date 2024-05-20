class Solution {

    int[][] directions = new int[][] {
            { 1, 0 },
            { 1, -1 },
            { 0, -1 },
            { -1, -1 },
            { -1, 0 },
            { -1, 1 },
            { 0, 1 },
            { 1, 1 }
    };

    private char[] getNeighbors(char[][] board, int x, int y) {
        char[] neighbors = new char[8];

        for (int i = 0; i < 8; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                neighbors[i] = board[newX][newY];
            }
        }

        return neighbors;
    }

    private char[][] dfs(char[][] board, int[] click, boolean[][] visited) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        visited[click[0]][click[1]] = true;

        if (board[click[0]][click[1]] == 'E') {
            int neighborMinesCount = 0;
            for (char neighbor : getNeighbors(board, click[0], click[1])) {
                if (neighbor == 'M')
                    neighborMinesCount++;
            }
            if (neighborMinesCount == 0) {
                board[click[0]][click[1]] = 'B';
                for (int i = 0; i < 8; i++) {
                    int newX = click[0] + directions[i][0];
                    int newY = click[1] + directions[i][1];
                    if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
                            && !visited[newX][newY]) {
                        board = dfs(board, new int[] { newX, newY }, visited);
                    }
                }
            } else {
                board[click[0]][click[1]] = (char) (neighborMinesCount + '0');
                return board;
            }
        }
        return board;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        return dfs(board, click, new boolean[board.length][board[0].length]);
    }
}