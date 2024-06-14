class Solution {
    public void gameOfLife(int[][] board) {
        int[][] neighbors = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        // 2 = will die, 3 = will become alive
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int currCell = board[i][j];
                int neighbor1Count = 0;
                for (int[] neighbor : neighbors) {
                    int neighborX = i + neighbor[0];
                    int neighborY = j + neighbor[1];

                    if (neighborX >= 0 && neighborY >= 0 && neighborX < board.length && neighborY < board[0].length) {
                        int neighborVal = board[neighborX][neighborY];
                        if (neighborVal == 1 || neighborVal == 2) {
                            neighbor1Count++;
                        }
                    }
                }

                if (currCell == 1 && (neighbor1Count < 2 || neighbor1Count > 3)) {
                    board[i][j] = 2;
                }

                if (currCell == 0 && neighbor1Count == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }

    }
}