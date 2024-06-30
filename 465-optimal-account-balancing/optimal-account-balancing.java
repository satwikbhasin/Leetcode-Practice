import java.util.*;

class Solution {
    
    private Map<String, Integer> memo;
    
    private int dfs(List<Integer> debts, int idx) {
        // Skip settled accounts
        while (idx < debts.size() && debts.get(idx) == 0) {
            idx++;
        }

        // All accounts settled
        if (idx == debts.size()) {
            return 0;
        }

        // Create a key for the current state using a more structured approach
        String key = generateKey(debts, idx);
        
        // Check if the result for this state is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int transactions = Integer.MAX_VALUE;
        
        // Try settling debt at idx with subsequent debts
        for (int i = idx + 1; i < debts.size(); i++) {
            if (debts.get(idx) * debts.get(i) < 0) {
                // Settle debt[idx] with debt[i]
                debts.set(i, debts.get(i) + debts.get(idx));
                transactions = Math.min(transactions, 1 + dfs(debts, idx + 1));
                debts.set(i, debts.get(i) - debts.get(idx));
            }
        }

        // Store the result in memoization map
        memo.put(key, transactions);
        return transactions;
    }

    private String generateKey(List<Integer> debts, int idx) {
        // Generate a key for the current state
        List<Integer> currentState = new ArrayList<>();
        for (int i = idx; i < debts.size(); i++) {
            if (debts.get(i) != 0) {
                currentState.add(debts.get(i));
            }
        }
        Collections.sort(currentState);
        return currentState.toString();
    }

    public int minTransfers(int[][] transactions) {
        // Initialize memoization map
        memo = new HashMap<>();
        
        HashMap<Integer, Integer> accounts = new HashMap<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];

            accounts.put(from, accounts.getOrDefault(from, 0) - amount);
            accounts.put(to, accounts.getOrDefault(to, 0) + amount);
        }

        List<Integer> debts = new ArrayList<>();
        for (int account : accounts.values()) {
            if (account != 0) {
                debts.add(account);
            }
        }

        return dfs(debts, 0);
    }
}