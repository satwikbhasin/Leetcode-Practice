class Solution {
    public int jump(int[] nums) {
        int minJumps = 0;
        int currentJumpsFarthest = 0;
        int currentJumpsEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentJumpsFarthest = Math.max(currentJumpsFarthest, i + nums[i]);

            if (i == currentJumpsEnd) {
                minJumps++;
                currentJumpsEnd = currentJumpsFarthest;

                if (currentJumpsEnd >= nums.length - 1)
                    break;
            }
        }

        return minJumps;
    }
}