class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> elementFrequencies = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        
        for(int i = 0; i < nums.length; i++){
            if(!elementFrequencies.containsKey(nums[i])){
                elementFrequencies.put(nums[i], 0);
            }
            elementFrequencies.put(nums[i], elementFrequencies.get(nums[i]) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : elementFrequencies.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }

        return res;
    }
}