class Solution {
    private void dfs(String s, List<String> results, List<String> wordDict, StringBuilder current, int startIndex,
            int spacesAdded) {
        if (startIndex == s.length()) {
            results.add(current.toString().trim());
        }

        for (int i = startIndex + 1; i <= s.length(); i++) {
            String substring = s.substring(startIndex, i);
            if (wordDict.contains(substring)) {
                int beforeLength = current.length();
                if (current.length() != 0)
                    current.append(" ");
                current.append(substring);
                dfs(s, results, wordDict, current, i, spacesAdded + 1);
                current.setLength(beforeLength);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        dfs(s, results, wordDict, new StringBuilder(), 0, 0);
        return results;
    }
}