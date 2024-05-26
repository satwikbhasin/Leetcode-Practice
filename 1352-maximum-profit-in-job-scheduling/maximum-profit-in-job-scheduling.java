import java.util.*;

class Job {
    int startTime, endTime, profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Create an array of jobs
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        // Sort the jobs by their end time
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        // Initialize an array to store the maximum profit
        int[] maxProfits = new int[n];
        maxProfits[0] = jobs[0].profit; // Initialize the first profit

        // Calculate maximum profit for each job
        for (int i = 1; i < n; i++) {
            int currentProfit = jobs[i].profit; // Current job's profit
            int lastNonOverlappingIndex = findLastNonOverlappingJob(jobs, i); // Find the last non-overlapping job
            if (lastNonOverlappingIndex != -1) {
                currentProfit += maxProfits[lastNonOverlappingIndex]; // Add profit of last non-overlapping job
            }

            // Store the maximum profit at this index
            maxProfits[i] = Math.max(currentProfit, maxProfits[i - 1]);
        }

        // Return the maximum profit
        return maxProfits[n - 1];
    }

    private int findLastNonOverlappingJob(Job[] jobs, int index) {
    int low = 0;
    int high = index - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (jobs[mid].endTime <= jobs[index].startTime) {
            if (jobs[mid + 1].endTime <= jobs[index].startTime) {
                low = mid + 1;
            } else {
                return mid;
            }
        } else {
            high = mid - 1;
        }
    }

    return -1;
}

}
