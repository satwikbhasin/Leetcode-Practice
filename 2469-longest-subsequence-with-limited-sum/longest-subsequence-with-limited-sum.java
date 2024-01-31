class Solution {
    public int[] answerQueries(int[] array, int[] queries) {
        Arrays.sort(array);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int j = 0;
            for (j = 0; j < array.length; j++) {
                if (sum + array[j] > queries[i]) {
                    result[i] = j;
                    break;
                }
                sum += array[j];
            }
            if (j == array.length) result[i] = array.length;
        }
        return result;
    }
}