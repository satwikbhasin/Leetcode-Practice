// O(nlogn) Time, O(1) Space
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int hIndex = Integer.MIN_VALUE;

        for (int i = 0; i < citations.length; i++) {
            int h = Math.min(citations[i], citations.length - i);
            hIndex = Math.max(hIndex, h);
        }

        return hIndex;
    }
}