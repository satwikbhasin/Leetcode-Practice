class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> set = new HashMap<>();
        List<List<String>> sol = new ArrayList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String word = new String(charArray);

            if (!set.containsKey(word)) {
                set.put(word, new ArrayList<>());
            }

            set.get(word).add(str);
        }

        for (Map.Entry<String, List<String>> entry : set.entrySet()) {
            List<String> list = entry.getValue();
            sol.add(list);
        }

        return sol;
    }
}