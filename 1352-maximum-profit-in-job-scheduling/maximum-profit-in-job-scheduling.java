class Job {
    int startTime, endTime, profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class Solution {
    // maximum number of jobs are 50000
    int[] memo = new int[50001];

    private int findNextJob(int[] startTime, int lastEndingTime) {
        int start = 0, end = startTime.length - 1, nextIndex = startTime.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }

    private int findMaxProfit(Job[] jobs, int[] startTime, int n, int position) {
        // 0 profit if we have already iterated over all the jobs
        if (position == n) {
            return 0;
        }

        // return result directly if it's calculated
        if (memo[position] != -1) {
            return memo[position];
        }

        // nextIndex is the index of next non-conflicting job
        int nextIndex = findNextJob(startTime, jobs[position].endTime);

        // find the maximum profit of our two options: skipping or scheduling the
        // current job
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1),
                jobs[position].profit + findMaxProfit(jobs, startTime, n, nextIndex));

        // return maximum profit and also store it for future reference (memoization)
        return memo[position] = maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.fill(memo, -1);

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.startTime));

        // binary search will be used in startTime so store it as separate list
        for (int i = 0; i < n; i++) {
            startTime[i] = jobs[i].startTime;
        }

        return findMaxProfit(jobs, startTime, n, 0);
    }
}
