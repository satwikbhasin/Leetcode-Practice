class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            list.add(count);
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            indices.add(i);
        }
        
        Collections.sort(indices, (a, b) -> Integer.compare(list.get(a), list.get(b)));

        for (int i = 0; i < k; i++) {
            ans.add(i,indices.get(i));
        }

        int[] array = ans.stream().mapToInt(Integer::intValue).toArray();

        return array;
    }
}