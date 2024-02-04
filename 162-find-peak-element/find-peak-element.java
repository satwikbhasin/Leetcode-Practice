class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(mid == 0){
                return nums[mid + 1] < nums[mid] ? 0 : 1;
            } else if (mid == nums.length - 1){
                return nums[mid - 1] < nums[mid] ? nums.length - 1 : nums.length - 2;
            } else {
                if(nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]){
                return mid;
            } 
            if (nums[mid - 1] >= nums[mid + 1]){
                right = mid -  1;
            } else {
                left = mid + 1;
            }
            }
            }
        return left;
    }
}