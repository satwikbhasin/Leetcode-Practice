// B I N A R Y   S E A R C H
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int daysNeeded = 1;
            int currentWeight = 0;

            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    daysNeeded++;
                    currentWeight = 0;
                }
                currentWeight += weight;
            }

            if (daysNeeded <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}