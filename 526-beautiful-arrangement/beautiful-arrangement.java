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

public class Solution {
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}