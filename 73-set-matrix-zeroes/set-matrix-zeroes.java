// O(m * n) Time, O(1) Space
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has zero
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and first column to mark zero cells
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set zero cells based on marks in first row and first column
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row to zero if necessary
        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set first column to zero if necessary
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}


// O(m * n) Time, O(m + n) Space
// class Solution {
// public void setZeroes(int[][] matrix) {
// Set<Integer> zeroRows = new HashSet<>();
// Set<Integer> zeroCols = new HashSet<>();

// // find all rows and columns which have 0's -> O(m * n)
// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[0].length; j++) {
// if (matrix[i][j] == 0) {
// zeroRows.add(i);
// zeroCols.add(j);
// }
// }
// }

// // Set all cells whose row or col is marked to have 0 -> O(m * n)
// for (int i = 0; i < matrix.length; i++) {
// for (int j = 0; j < matrix[0].length; j++) {
// if (zeroRows.contains(i) || zeroCols.contains(j)) {
// matrix[i][j] = 0;
// }
// }
// }

// }
// }