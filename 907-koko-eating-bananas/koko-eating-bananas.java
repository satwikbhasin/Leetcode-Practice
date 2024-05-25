class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for (int pile : piles) {
            if (pile > high)
                high = pile;
        }
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isKfeasible(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isKfeasible(int[] piles, int h, int prospectK) {
        int currentHours = 0;
        for (int pile : piles) {
            currentHours += Math.ceil((double) pile / prospectK);
        }
        return currentHours <= h;
    }
}