class Solution {
    public int jump(int[] nums) {
        int currentMaxReach = 0;
        int nextMaxReach = 0;
        int minJumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);

            if (i == currentMaxReach) {
                minJumps++;
                currentMaxReach = nextMaxReach;

                if (currentMaxReach >= nums.length - 1)
                    break;
            }
        }

        return minJumps;
    }
}
