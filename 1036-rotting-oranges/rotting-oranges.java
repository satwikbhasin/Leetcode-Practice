class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        if (freshOranges != 0 && queue.isEmpty())
            return -1;

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            boolean hasRotten = false;
            for (int i = 0; i < currentLevelSize; i++) {
                int[] currentCell = queue.remove();
                int x = currentCell[0];
                int y = currentCell[1];

                if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visited[x + 1][y]) {
                    grid[x + 1][y] = 2;
                    visited[x + 1][y] = true;
                    queue.add(new int[] { x + 1, y });
                    freshOranges--;
                    hasRotten = true;
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1 && !visited[x][y + 1]) {
                    grid[x][y + 1] = 2;
                    visited[x][y + 1] = true;
                    queue.add(new int[] { x, y + 1 });
                    freshOranges--;
                    hasRotten = true;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited[x - 1][y]) {
                    grid[x - 1][y] = 2;
                    visited[x - 1][y] = true;
                    queue.add(new int[] { x - 1, y });
                    freshOranges--;
                    hasRotten = true;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited[x][y - 1]) {
                    grid[x][y - 1] = 2;
                    visited[x][y - 1] = true; 
                    queue.add(new int[] { x, y - 1 });
                    freshOranges--;
                    hasRotten = true;
                }
            }
            if(hasRotten) minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}