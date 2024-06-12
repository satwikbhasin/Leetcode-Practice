class Solution {
    public int jump(int[] nums) {
        int minJumps = 0;
        int currentJumpsFarthest = 0;
        int currentJumpsEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentJumpsEnd = Math.max(currentJumpsEnd, i + nums[i]);

            if(i == currentJumpsFarthest){
                minJumps++;
                currentJumpsFarthest = currentJumpsEnd;
            }
        }

        return minJumps;
    }
}