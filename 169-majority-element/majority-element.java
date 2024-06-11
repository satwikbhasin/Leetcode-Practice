class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int candidateCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidateCount == 0 && nums[i] != candidate) {
                candidate = nums[i];
            } 
            
            if (nums[i] != candidate) {
                candidateCount--;
            } else if (nums[i] == candidate) {
                candidateCount++;
            }
        }

        return candidate;
    }
}