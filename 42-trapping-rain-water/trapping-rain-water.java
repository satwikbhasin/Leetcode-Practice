class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int left = 0;
        int right = n - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int waterTrapped = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax) leftMax = Math.max(leftMax, height[left]);
                else waterTrapped += leftMax - height[left];
                left++;
            } else {
                if(height[right] >= rightMax) rightMax = Math.max(rightMax, height[right]);
                else waterTrapped += rightMax - height[right];
                right--;
            }
        }

        return waterTrapped;
    }
}