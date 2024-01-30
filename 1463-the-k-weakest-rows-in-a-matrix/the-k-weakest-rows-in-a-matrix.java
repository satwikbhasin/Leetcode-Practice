class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> soldierRowMap = new HashMap<>();
        int[] ans = new int[k];
        for(int i = 0 ; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            soldierRowMap.put(i, count);
        }

        for(int i = 0; i< k; i++){
        int min = mat[0].length + 1;
        int minKey = -1;
            for(int j = 0; j< mat.length; j++){
            Integer count = soldierRowMap.get(j);
                if (count != null && count < min) {
                    min = count;
                    minKey = j;
                }
        }
        ans[i] = minKey;
        soldierRowMap.remove(minKey);
        }
        
        return ans;
    }
}