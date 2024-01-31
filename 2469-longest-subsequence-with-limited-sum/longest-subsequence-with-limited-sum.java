class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        int[] answer = new int[queries.length];

        for( int i = 0; i < queries.length; i++){
            int left = 0;
            int right = nums.length - 1;
            int counter = 0;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(nums[mid] <= queries[i]){
                    counter = mid + 1;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                answer[i] = counter;
            }
        } 
        return answer;
    }
}