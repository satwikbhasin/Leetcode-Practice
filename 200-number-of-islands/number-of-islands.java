class Solution {
    private void dfs(char[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return;
        }

        if(grid[x][y] == '0'){
            return;
        }

        grid[x][y] = '0';

        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}