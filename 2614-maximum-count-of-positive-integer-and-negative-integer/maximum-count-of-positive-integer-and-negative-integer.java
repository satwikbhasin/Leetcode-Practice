class Solution {
    public int maximumCount(int[] nums) {

        int negative_last = -1;
        int positive_first = -1;
        int zero_count = 0;

        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= 0){
                right = mid - 1;
            } else {
                left = mid + 1;
                negative_last = mid;
            }
        }

        left = 0;
        right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] <= 0){
                left = mid + 1;
            } else if (nums[mid] > 0){
                right = mid - 1;
                positive_first = mid;
            }
        }
if(positive_first < 0){
    zero_count = nums.length - negative_last - 1;
} else {
        zero_count = positive_first - negative_last - 1;
}

        int positive_count = nums.length - zero_count - negative_last - 1;
        int negative_count = negative_last + 1;

        if(negative_last == -1 && positive_first == -1){
            return 0;
        }
        
        return Math.max(negative_count, positive_count);
    }
}