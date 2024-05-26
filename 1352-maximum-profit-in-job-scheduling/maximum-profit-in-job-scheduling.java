import java.util.Arrays;
import java.util.Comparator;

class Job {
    int start, end, profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includedProfit = jobs[i].profit;
            int l = search(jobs, i);
            if (l != -1) {
                includedProfit += dp[l];
            }

            dp[i] = Math.max(includedProfit, dp[i - 1]);
        }

        return dp[n - 1];
    }

    private int search(Job[] jobs, int index) {
        int start = 0, end = index - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (jobs[mid].end <= jobs[index].start) {
                if (jobs[mid + 1].end <= jobs[index].start) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
