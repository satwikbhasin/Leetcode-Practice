class Solution {
    private int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    private int dfs(int[][] grid, int x, int y, boolean[][] visited, int islandIndex) {
        int area = 1;

        visited[x][y] = true;
        grid[x][y] = islandIndex;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1
                    && !visited[newX][newY]) {
                area += dfs(grid, newX, newY, visited, islandIndex);
            }
        }

        return area;
    }

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] islandSizes = new int[m * n + 2];

        int areaOfLargestIsland = 0;
        boolean[][] visited = new boolean[m][n];

        int islandIndex = 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    islandSizes[islandIndex] = dfs(grid, i, j, visited, islandIndex);
                    areaOfLargestIsland = Math.max(areaOfLargestIsland, islandSizes[islandIndex]);
                    islandIndex++;
                }
            }
        }

        if (m * n == areaOfLargestIsland)
            return areaOfLargestIsland;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> connectedIslands = new HashSet<>();
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];

                        if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length
                                && grid[newX][newY] > 1) {
                            connectedIslands.add(grid[newX][newY]);
                        }
                    }
                    int currArea = 1;
                    for (int index : connectedIslands) {
                        currArea += islandSizes[index];
                    }
                    areaOfLargestIsland = Math.max(areaOfLargestIsland, currArea);
                }
            }
        }

        return areaOfLargestIsland;
    }
}
