class Solution {
    List<Integer> sol;
    boolean[][] visited;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

    private void traverse(int x, int y, int dir, int[][] matrix) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        sol.add(matrix[x][y]);

        int newX = x + directions[dir][0];
        int newY = y + directions[dir][1];

        if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length || visited[newX][newY]) {
            dir = (dir + 1) % 4; // change direction
            newX = x + directions[dir][0];
            newY = y + directions[dir][1];
        }

        traverse(newX, newY, dir, matrix);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        visited = new boolean[matrix.length][matrix[0].length];
        sol = new ArrayList<>();

        traverse(0, 0, 0, matrix);

        return sol;
    }
}
