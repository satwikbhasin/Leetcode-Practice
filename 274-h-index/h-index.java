class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        int hIndex = 0;

        for (int i = 0; i < n; i++) {
            int h = Math.min(citations[i], n - i);
            hIndex = Math.max(hIndex, h);
        }

        return hIndex;
    }
}