class Solution {
    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }

        int oldColor = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        fill(image, sr, sc, oldColor, color);
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != oldColor) {
            return;
        }

        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        fill(image, sr - 1, sc, oldColor, newColor); // Up
        fill(image, sr + 1, sc, oldColor, newColor); // Down
        fill(image, sr, sc - 1, oldColor, newColor); // Left
        fill(image, sr, sc + 1, oldColor, newColor); // Right
    }
}