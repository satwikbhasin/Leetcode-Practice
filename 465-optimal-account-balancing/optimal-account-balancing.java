class Solution {
    HashMap<Integer, Integer> accounts;

    private int dfs(List<Integer> debts, int idx) {
        while (idx < debts.size() && debts.get(idx) == 0) {
            idx++;
        }

        if (idx == debts.size()) {
            return 0;
        }

        int transactions = Integer.MAX_VALUE;
        for (int i = idx + 1; i < debts.size(); i++) {
            if (debts.get(idx) * debts.get(i) < 0) {
                debts.set(i, debts.get(i) + debts.get(idx));
                transactions = Math.min(transactions, 1 + dfs(debts, idx + 1));
                debts.set(i, debts.get(i) - debts.get(idx));
            }
        }

        return transactions;
    }

    public int minTransfers(int[][] transactions) {
        accounts = new HashMap<>();

        for (int[] t : transactions) {
            int from = t[0];
            int to = t[1];
            int amount = t[2];

            accounts.put(from, accounts.getOrDefault(from, 0) - amount);
            accounts.put(to, accounts.getOrDefault(to, 0) + amount);
        }

        List<Integer> debts = new ArrayList<>();

        for (int balance : accounts.values()) {
            if (balance != 0) {
                debts.add(balance);
            }
        }

        return dfs(debts, 0);
    }
}