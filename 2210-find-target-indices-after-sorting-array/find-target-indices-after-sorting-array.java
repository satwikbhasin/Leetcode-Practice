class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int leftmost = -1;
        int rightmost = -1;


        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                rightmost = mid;
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            }

        left = 0;
        right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                leftmost = mid;
                right = mid - 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(leftmost == -1){
            return list;
        }

        for( int i = leftmost; i <= rightmost ; i++){
            list.add(i);
        }

        return list;
    }
}