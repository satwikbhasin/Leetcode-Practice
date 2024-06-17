class Solution {
    HashSet<String> wordSet;
    HashMap<String, Boolean> memo;

    private boolean dfs(String remaining) {

        if (remaining.length() == 0) {
            return true;
        }

        if (memo.containsKey(remaining)) {
            return memo.get(remaining);
        }

        for (int i = 1; i <= remaining.length(); i++) {
            String substring = remaining.substring(0, i);
            if (wordSet.contains(substring)) {
                if (dfs(remaining.substring(i))) {
                    memo.put(remaining.substring(i), true);
                    return true;
                }
            }
        }
        
        memo.put(remaining, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return dfs(s);
    }
}