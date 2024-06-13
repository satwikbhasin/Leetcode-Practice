// O(1) Time, O(1) Space
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> subgridSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !colSet.add(board[j][i]))
                    return false;
            }

            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    int rowIndex = 3 * (i / 3) + k;
                    int colIndex = 3 * (i % 3) + l;
                    if (board[rowIndex][colIndex] != '.' && !subgridSet.add(board[rowIndex][colIndex]))
                        return false;
                }
            }
        }

        return true;
    }
}
