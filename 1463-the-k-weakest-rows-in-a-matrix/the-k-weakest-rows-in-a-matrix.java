class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> soldierCountMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int[] ans = new int[k];
        int count = -1;
        for(int i = 0 ; i < mat.length; i++){
            int left = 0;
            int right = mat[i].length - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(mat[i][mid] == 0){
                    count = mid;
                    right = mid - 1;
                } else if(mat[i][mid] == 1){
                    left = mid + 1;
                }
            }
            if(count == -1){
            soldierCountMap.put(i, mat[i].length);
            minHeap.add(mat[i].length);
            } else {
            soldierCountMap.put(i, count);
            minHeap.add(count);
            }
            count = -1;
        }

for(int i = 0; i <k; i++){
 if (!minHeap.isEmpty()) {
            int temp = minHeap.poll();
            for (Map.Entry<Integer, Integer> entry : soldierCountMap.entrySet()) {
            if (entry.getValue().equals(temp)) {
                ans[i] = entry.getKey();
                soldierCountMap.remove(ans[i]);
                break;
            }
        }
        }
}
   


        return ans;
    }
}