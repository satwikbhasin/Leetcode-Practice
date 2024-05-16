import java.util.List;

class Solution {
    private boolean dfs(String remainingString, List<String> wordDict, Map<String, Boolean> memo) {
        if (wordDict.contains(remainingString)) {
            return true;
        }

        if (memo.containsKey(remainingString)) {
            return memo.get(remainingString);
        }

        for (int i = 1; i < remainingString.length(); i++) {
            String substring = remainingString.substring(0, i);
            if (wordDict.contains(substring)) {
                String newRemainingString = remainingString.substring(i);
                if (dfs(newRemainingString, wordDict, memo)) {
                    memo.put(remainingString, false);
                    return true;
                }
            }
        }
        memo.put(remainingString, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(s, wordDict, memo);
    }
}
