class Solution {
    private String topologialSort(HashMap<Character, HashSet<Character>> graph,
            HashMap<Character, HashSet<Character>> indegreeMap) {

        PriorityQueue<Character> pq = new PriorityQueue<>();

        for (Map.Entry<Character, HashSet<Character>> entry : indegreeMap.entrySet()) {
            if (entry.getValue().size() == 0) {
                pq.add(entry.getKey());
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            char curr = pq.poll();
            ans.append(curr);
            for (char neighbor : graph.get(curr)) {
                if (indegreeMap.get(neighbor).contains(curr)) {
                    indegreeMap.get(neighbor).remove(curr);
                    if (indegreeMap.get(neighbor).isEmpty()) {
                        pq.add(neighbor);
                    }
                }
            }
        }

        for (Map.Entry<Character, HashSet<Character>> entry : indegreeMap.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                return null;
            }
        }

        return ans.toString();
    }

    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, HashSet<Character>> indegreeMap = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
                indegreeMap.put(c, new HashSet<>());
            }
        }

        String prev = words[0];
        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            if (prev.startsWith(curr) && prev.length() > curr.length()) {
                return "";
            }
            for (int j = 0; j < prev.length() && j < curr.length(); j++) {
                if (curr.charAt(j) != prev.charAt(j)) {
                    graph.get(prev.charAt(j)).add(curr.charAt(j));
                    break;
                }
            }
            prev = curr;
        }

        for (Map.Entry<Character, HashSet<Character>> entry : graph.entrySet()) {
            for (char c : entry.getValue()) {
                indegreeMap.get(c).add(entry.getKey());
            }
        }

        String result = topologialSort(graph, indegreeMap);

        return result != null ? result : "";

    }
}