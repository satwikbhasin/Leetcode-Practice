class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int longestSeq = 1;
        int currStreak = 1;
        boolean streakStarted = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // this line is added to handle duplicates

                boolean streakMaker = nums[i] - nums[i - 1] == 1 || nums[i] == nums[i - 1];
                if (streakMaker && !streakStarted) { // start streak
                    streakStarted = true;
                    currStreak = 2;
                } else if (streakMaker && streakStarted) { // streak going on
                    currStreak++;
                } else if (!streakMaker && streakStarted) { // break streak
                    longestSeq = Math.max(longestSeq, currStreak);
                    streakStarted = false;
                    currStreak = 1;
                }
            }
        }

        longestSeq = Math.max(longestSeq, currStreak);

        return longestSeq;
    }
}