class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> set = new HashSet<>();
        for (char[] row : board) {
            set.clear();
            for (char cell : row) {
                if (cell != '.') {
                    int val = cell - '0';
                    if (val < 1 || val > 9 || set.contains(val)) {
                        return false;
                    }
                    set.add(val);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int val = board[j][i] - '0';
                    if (val < 1 || val > 9 || set.contains(val)) {
                        return false;
                    }
                    set.add(val);
                }
            }
        }

        for (int block = 0; block < 9; block++) {
            set.clear();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int rowIndex = 3 * (block / 3) + i;
                    int colIndex = 3 * (block % 3) + j;
                    if (board[rowIndex][colIndex] != '.') {
                        int val = board[rowIndex][colIndex] - '0';
                        if (val < 1 || val > 9 || set.contains(val)) {
                            return false;
                        }
                        set.add(val);
                    }
                }
            }
        }

        return true;
    }
}