class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i =1; i <= nums.length; i++){
            int greaterThanEqualToCount = 0;
            int left = 0;
            int right = nums.length - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(nums[mid] >= i){
                    right = mid - 1;
                    if((nums.length - mid) > greaterThanEqualToCount){
                    greaterThanEqualToCount = nums.length - mid;
                    }
                } else {
                    left = mid + 1;
                }
        }
        if(greaterThanEqualToCount == i){
                        return greaterThanEqualToCount;
                    }
        }
        return -1; 
    }
}