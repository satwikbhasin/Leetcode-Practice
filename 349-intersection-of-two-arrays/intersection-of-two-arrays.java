class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[nums1.length > nums2.length ? nums2.length : nums1.length]; 
        int counter = 0;
        for(int i =0; i < nums1.length; i++){
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                continue;
            }
            int left = 0;
            int right = nums2.length - 1;
            while(left<=right){
                int mid = left + (right - left)/2;
                if(nums1[i] == nums2[mid]){
                    ans[counter] = nums1[i];
                    counter++;
                    break;
                } else if (nums1[i] > nums2[mid]){
                    left = mid + 1;
                } else if (nums1[i] < nums2[mid]){
                    right = mid - 1;
                }
            }
        }
         return Arrays.copyOf(ans, counter);
        }
}