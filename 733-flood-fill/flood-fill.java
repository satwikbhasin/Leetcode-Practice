class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[image.length][image[0].length];

        queue.add(new int[] { sr, sc });
        visited[sr][sc] = true;

        int ogColor = image[sr][sc];

        while (!queue.isEmpty()) {
            int[] currPixel = queue.remove();

            int x = currPixel[0];
            int y = currPixel[1];

            if (image[x][y] == ogColor) {
                image[x][y] = color;
                visited[x][y] = true;
            }

            if (x + 1 < image.length && !visited[x + 1][y] && image[x+1][y] == ogColor)
                queue.add(new int[] { x + 1, y });
            if (y + 1 < image[0].length && !visited[x][y + 1] && image[x][y+1] == ogColor)
                queue.add(new int[] { x, y + 1 });
            if (x - 1 >= 0 && !visited[x - 1][y] && image[x-1][y] == ogColor)
                queue.add(new int[] { x - 1, y });
            if (y - 1 >= 0 && !visited[x][y - 1] && image[x][y-1] == ogColor)
                queue.add(new int[] { x, y - 1 });

        }
        return image;
    }
}