// O(m * n) Time, O(1) Space, DFS 
class Solution {
    int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    private void dfs(int[] island, char[][] grid) {
        int x = island[0];
        int y = island[1];

        grid[x][y] = '0';

        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && grid[newX][newY] == '1') {
                dfs(new int[] { newX, newY }, grid);
            }
        }

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(new int[] { i, j }, grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}

// O(m * n) Time, O(m * n) Space, BFS
// class Solution {
// int[][] DIRECTIONS = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
// };

// private void bfs(int[] island, char[][] grid) {
// Queue<int[]> queue = new LinkedList<>();
// grid[island[0]][island[1]] = '0';
// queue.offer(island);

// while (!queue.isEmpty()) {
// int[] cell = queue.poll();
// int x = cell[0];
// int y = cell[1];
// for (int[] direction : DIRECTIONS) {
// int newX = x + direction[0];
// int newY = y + direction[1];

// if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
// && grid[newX][newY] == '1') {
// queue.offer(new int[] { newX, newY });
// grid[newX][newY] = '0';
// }
// }
// }
// }

// public int numIslands(char[][] grid) {
// if (grid == null || grid.length == 0 || grid[0].length == 0) {
// return 0;
// }

// int islandCount = 0;

// for (int i = 0; i < grid.length; i++) {
// for (int j = 0; j < grid[0].length; j++) {
// if (grid[i][j] == '1') {
// bfs(new int[] { i, j }, grid);
// islandCount++;
// }
// }
// }

// return islandCount;
// }
// }