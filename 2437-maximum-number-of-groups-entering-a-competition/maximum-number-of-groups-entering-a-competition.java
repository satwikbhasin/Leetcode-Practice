class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int total_groups = 0;
        int groupCount = 1;
        int memberCount = 0;
        int last_sum = 0;
        int curr_sum = 0;
        for(int i = 0; i < grades.length; i++){
            if(memberCount > groupCount){
                memberCount = 1;
                if(curr_sum > last_sum){
                    last_sum = curr_sum;                
                    groupCount++;
                    curr_sum = 0;
                }
            } else {
                memberCount++;
            }
            curr_sum += grades[i];
        }
        return groupCount;
    }
}