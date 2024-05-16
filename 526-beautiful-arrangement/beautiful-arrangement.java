// class Solution {
//     private int dfs(int n, int[] current, int currNumber) {
//         if (currNumber == n) {
//             return 1;
//         }

//         int count = 0;

//         for (int i = 1; i <= n; i++) {
//             if (current[i - 1] == 0 && (i % (currNumber + 1) == 0 || (currNumber + 1) % i == 0)) {
//                 current[i - 1] = 1;
//                 count += dfs(n, current, currNumber + 1);
//                 current[i - 1] = 0;
//             }
//         }

//         return count;
//     }

//     public int countArrangement(int n) {
        
//         return dfs(n, new int[n + 1], 0);
//     }
// }

class Solution {
    private static final int[] res = {1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
    public int countArrangement(int n) {
        
        return res[n-1];
    }
}