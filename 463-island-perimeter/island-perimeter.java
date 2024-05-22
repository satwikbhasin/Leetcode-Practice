class Solution {

    private List<Integer> getNeighbors(int[][] grid, int x, int y) {
        List<Integer> neighbors = new ArrayList<>();

        if (x != 0)
            neighbors.add(grid[x - 1][y]);
        if (y != 0)
            neighbors.add(grid[x][y - 1]);
        if (x != grid.length - 1)
            neighbors.add(grid[x + 1][y]);
        if (y != grid[0].length - 1)
            neighbors.add(grid[x][y + 1]);

        return neighbors;
    }

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 && grid[0].length == 0) return 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];        

        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
            if (queue.size() > 0)
                break;
        }

        int[][] directions ={{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!queue.isEmpty()){
            int[] currentCell = queue.remove();
            int x = currentCell[0];
            int y = currentCell[1];

            for( int[] direction : directions){
                int neighborX = x + direction[0];
                int neighborY = y + direction[1];

                if (neighborX < 0 || neighborY < 0 || neighborX >= grid.length || neighborY >= grid[0].length || grid[neighborX][neighborY] == 0){
                    perimeter++;
                } else if (!visited[neighborX][neighborY]) {
                    visited[neighborX][neighborY] = true;
                    queue.add(new int[]{neighborX, neighborY});
                }
            }
        }

        return perimeter;
    }
}