class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] < mid){
            ans = mid;
            } else if (nums[mid] > mid) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(ans == -1){
            return nums.length;
        } else {
            return ans;
        }
    }
}