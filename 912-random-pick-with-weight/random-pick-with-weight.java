class Solution {
    int[] prefixSum;
    int wSum;

    public Solution(int[] w) {
        this.prefixSum = w;
        this.prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            this.prefixSum[i] += this.prefixSum[i - 1];
        }
        wSum = prefixSum[w.length - 1];
    }

    public int pickIndex() {
        Double target = wSum * Math.random();

        int left = 0;
        int right = prefixSum.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (this.prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */