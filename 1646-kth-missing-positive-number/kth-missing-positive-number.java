class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int temp = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int difference = arr[mid] - mid - 1;
            if(difference >= k){
                right = mid - 1;
                temp = mid;
            } else if(difference < k){
                left = mid + 1;
                temp = mid;
            }
        }
        return left + k;
    }
}