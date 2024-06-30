// class Solution {

//     private int dfs(List<Integer> debts, int idx) {
//         while (idx < debts.size() && debts.get(idx) == 0) {
//             idx++;
//         }

//         if (idx == debts.size()) {
//             return 0;
//         }

//         int transactions = Integer.MAX_VALUE;
//         for (int i = idx + 1; i < debts.size(); i++) {
//             if (debts.get(idx) * debts.get(i) < 0) {
//                 debts.set(i, debts.get(i) + debts.get(idx));
//                 transactions = Math.min(transactions, 1 + dfs(debts, idx + 1));
//                 debts.set(i, debts.get(i) - debts.get(idx));
//             }
//         }

//         return transactions;
//     }

//     public int minTransfers(int[][] transactions) {
//         HashMap<Integer, Integer> accounts = new HashMap<>();

//         for (int[] transaction : transactions) {
//             int from = transaction[0];
//             int to = transaction[1];
//             int amount = transaction[2];

//             accounts.put(from, accounts.getOrDefault(from, 0) - amount);
//             accounts.put(to, accounts.getOrDefault(to, 0) + amount);
//         }

//         List<Integer> debts = new ArrayList<>();

//         for (int account : accounts.values()) {
//             if (account != 0) {
//                 debts.add(account);
//             }
//         }

//         return dfs(debts, 0);
//     }

// }

class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> creditMap = new HashMap<>();
        for (int[] t : transactions) {
            creditMap.put(t[0], creditMap.getOrDefault(t[0], 0) + t[2]);
            creditMap.put(t[1], creditMap.getOrDefault(t[1], 0) - t[2]);
        }
        
        creditList = new ArrayList<>();
        for (int amount : creditMap.values()) {
            if (amount != 0) {
                creditList.add(amount);
            }
        }
        
        int n = creditList.size();
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        return n - dfs((1 << n) - 1, memo);
    }
    
    List<Integer> creditList;
    private int dfs(int totalMask, int[] memo) {
        if (memo[totalMask] != -1) {
            return memo[totalMask];
        }
        int balanceSum = 0, answer = 0;
        
        // Remove one person at a time in total_mask
        for (int i = 0; i < creditList.size(); i++) {
            int curBit = 1 << i;
            if ((totalMask & curBit) != 0) {
                balanceSum += creditList.get(i);
                answer = Math.max(answer, dfs(totalMask ^ curBit, memo));
            }
        }

        // If the total balance of total_mask is 0, increment answer by 1.
        memo[totalMask] = answer + (balanceSum == 0 ? 1 : 0);
        return memo[totalMask];
    }
}