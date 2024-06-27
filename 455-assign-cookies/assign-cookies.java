class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;

        int childIndex = 0;

        for (int cookieSize : s) {
            if (g[childIndex] <= cookieSize) {
                contentChildren++;
                childIndex++;
                if (childIndex == g.length) {
                    break;
                }
            }
        }

        return contentChildren;
    }
}