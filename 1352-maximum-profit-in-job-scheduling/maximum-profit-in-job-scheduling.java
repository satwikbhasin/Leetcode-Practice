class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class Solution {
    int memo[];

    private int findNextPossibleJob(Job[] jobs, int currentEndTime) {
        int left = 0;
        int right = jobs.length - 1;
        int nextPossibleJob = jobs.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].start >= currentEndTime) {
                nextPossibleJob = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nextPossibleJob;
    }

    private int findMaxProfit(Job[] jobs, int totalJobs, int currentJobIndex) {
        if (currentJobIndex == totalJobs) {
            return 0;
        }

        if (memo[currentJobIndex] != -1) {
            return memo[currentJobIndex];
        }

        int nextPossibleJobIndex = findNextPossibleJob(jobs, jobs[currentJobIndex].end);

        int maxProfit = Math.max(jobs[currentJobIndex].profit + findMaxProfit(jobs, totalJobs, nextPossibleJobIndex),
                findMaxProfit(jobs, totalJobs, currentJobIndex + 1));
        memo[currentJobIndex] = maxProfit;

        return maxProfit;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int totalJobs = startTime.length;

        Job[] jobs = new Job[totalJobs];
        for (int i = 0; i < totalJobs; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.start));

        memo = new int[totalJobs];
        Arrays.fill(memo, -1);

        return findMaxProfit(jobs, totalJobs, 0);
    }
}