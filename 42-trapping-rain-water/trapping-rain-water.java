// O(n) Time, O(1) Space
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
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
                right--;
            }
        }

        return waterTrapped;
    }
}