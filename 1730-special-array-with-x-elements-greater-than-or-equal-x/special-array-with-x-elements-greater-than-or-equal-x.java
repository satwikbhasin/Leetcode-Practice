class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i =1; i <= nums.length; i++){
            System.out.println("Now checking for " + i);
            int greaterThanEqualToCount = 0;
            int left = 0;
            int right = nums.length - 1;
            while(left<=right){
                int mid = left + (right-left)/2;
                System.out.println("At element: " + nums[mid]);
                if(nums[mid] >= i){
                    System.out.println("Case 1");
                    right = mid - 1;
                    if((nums.length - mid) > greaterThanEqualToCount){
                    greaterThanEqualToCount = nums.length - mid;
                    }
                    System.out.println("greaterThanEqualToCount: " + greaterThanEqualToCount);
                } else {
                    System.out.println("Case 2");
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