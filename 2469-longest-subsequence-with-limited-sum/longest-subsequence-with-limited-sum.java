class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answer = new int[queries.length];
        for( int i = 0; i < queries.length; i++){
            int sum = 0;
            int counter = 0;
            for(int j = 0; j < nums.length; j++){
                if((sum + nums[j]) > queries[i]){
                    break;
                }
                sum += nums[j];
                counter++;
            }
            answer[i] = counter;
        } 
        return answer;
    }
}