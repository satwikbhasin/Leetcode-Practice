class Solution {

    private static final int[][] directions = {
            { 1, 1 }, { 1, 0 }, { 0, 1 }, { -1, -1 },
            { -1, 1 }, { 1, -1 }, { 0, -1 }, { -1, 0 }
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;

        int clearPathLength = 1;

        while (!queue.isEmpty()) {
            int currentBreadth = queue.size();
            for (int i = 0; i < currentBreadth; i++) {
                int[] cell = queue.remove();
                int x = cell[0];
                int y = cell[1];

                if (x == grid.length - 1 && y == grid[0].length - 1)
                    return clearPathLength;

                for (int j = 0; j < 8; j++) {
                    int newX = x + directions[j][0];
                    int newY = y + directions[j][1];

                    if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]
                            && grid[newX][newY] == 0) {
                        queue.add(new int[] { newX, newY });
                        visited[newX][newY] = true;
                    }
                }
            }
            clearPathLength++;
        }
        return -1;
    }
}