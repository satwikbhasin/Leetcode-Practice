class Solution {

    private char[][] board;
    private int boardRows = 0;
    private int boardColumns = 0;

    private int[][] directions = new int[][] {
            { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 },
            { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }
    };

    private boolean isNeighborValid(int x, int y) {
        return x >= 0 && x < boardRows && y >= 0 && y < boardColumns;
    }

    private char[] getNeighbors(int x, int y) {
        char[] neighbors = new char[8];

        for (int i = 0; i < 8; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (isNeighborValid(newX, newY)) {
                neighbors[i] = board[newX][newY];
            }
        }

        return neighbors;
    }

    private char[][] dfs(int[] click, boolean[][] visited) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        visited[click[0]][click[1]] = true;

        if (board[click[0]][click[1]] == 'E') {
            int neighborMinesCount = 0;
            for (char neighbor : getNeighbors(click[0], click[1])) {
                if (neighbor == 'M')
                    neighborMinesCount++;
            }
            if (neighborMinesCount == 0) {
                board[click[0]][click[1]] = 'B';
                for (int i = 0; i < 8; i++) {
                    int newX = click[0] + directions[i][0];
                    int newY = click[1] + directions[i][1];
                    if (isNeighborValid(newX, newY) && !visited[newX][newY]) {
                        board = dfs(new int[] { newX, newY }, visited);
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
        this.board = board;
        this.boardRows = board.length;
        this.boardColumns = board[0].length;
        return dfs(click, new boolean[boardRows][boardColumns]);
    }
}