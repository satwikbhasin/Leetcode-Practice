class Solution {
    private static int[][] heights;
    private static int heightsRows;
    private static int heightsColumns;

    private static List<List<Integer>> getNeighbors(int x, int y) {
        List<List<Integer>> neighbors = new ArrayList<>();

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];

            if (newX >= 0 && newY >= 0 && newX < heightsRows && newY < heightsColumns) {
                List<Integer> cell = new ArrayList<>();
                cell.add(newX);
                cell.add(newY);
                neighbors.add(cell);
            }
        }

        return neighbors;
    }

    private static void DFS(int x, int y, boolean[][] oceanReach){
        oceanReach[x][y] = true;

        for( List<Integer> neighbor : getNeighbors(x, y)){
            int neighborX = neighbor.get(0);
            int neighborY = neighbor.get(1);
            if(heights[x][y] <= heights[neighborX][neighborY] && !oceanReach[neighborX][neighborY]){
                oceanReach[neighborX][neighborY] = true;
                DFS(neighborX, neighborY, oceanReach);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.heightsRows = heights.length;
        this.heightsColumns = heights[0].length;

        boolean[][] pacific = new boolean[heightsRows][heightsColumns];
        boolean[][] atlantic = new boolean[heightsRows][heightsColumns];

        for (int i = 0; i < heightsRows; i++) {
            DFS(i, 0, pacific);
            DFS(i, heightsColumns - 1, atlantic);
        }
        for (int i = 0; i < heightsColumns; i++) {
            DFS(0, i, pacific);
            DFS(heightsRows - 1, i, atlantic);
        }

        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < heightsRows; i++) {
            for (int j = 0; j < heightsColumns; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    results.add(cell);
                }
            }
        }

        return results;
    }
}