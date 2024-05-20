// class Solution {
//     public int maximalNetworkRank(int n, int[][] roads) {
//         if (roads.length == 0)
//             return 0;

//         Map<Integer, Integer> cityConnections = new HashMap<>();
//         Map<Integer, Set<Integer>> graph = new HashMap<>();

//         for (int i = 0; i < roads.length; i++) {
//             if (graph.containsKey(roads[i][0]) && cityConnections.containsKey(roads[i][0])) {
//                 graph.get(roads[i][0]).add(roads[i][1]);
//                 cityConnections.put(roads[i][0], cityConnections.get(roads[i][0]) + 1);
//             } else {
//                 graph.put(roads[i][0], new HashSet<>());
//                 graph.get(roads[i][0]).add(roads[i][1]);
//                 cityConnections.put(roads[i][0], 1);
//             }

//             if (graph.containsKey(roads[i][1]) && cityConnections.containsKey(roads[i][1])) {
//                 graph.get(roads[i][1]).add(roads[i][0]);
//                 cityConnections.put(roads[i][1], cityConnections.get(roads[i][1]) + 1);
//             } else {
//                 graph.put(roads[i][1], new HashSet<>());
//                 graph.get(roads[i][1]).add(roads[i][0]);
//                 cityConnections.put(roads[i][1], 1);
//             }
//         }

//         int maxNetworkRank = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i != j && cityConnections.get(i) != null && cityConnections.get(j) != null) {
//                     int networkRank = cityConnections.get(i) + cityConnections.get(j);
//                     if (graph.get(i).contains(j))
//                         networkRank--;
//                     maxNetworkRank = maxNetworkRank > networkRank ? maxNetworkRank : networkRank;
//                 }
//             }
//         }

//         return maxNetworkRank;
//     }
// }


class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        // Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        // Iterate on each possible pair of nodes.
        for (int node1 = 0; node1 < n; ++node1) {
            for (int node2 = node1 + 1; node2 < n; ++node2) {
                int currentRank = adj.getOrDefault(node1, Collections.emptySet()).size() +
                                  adj.getOrDefault(node2, Collections.emptySet()).size();

                // Find the current pair's respective network rank and store if it's maximum till now.
                if (adj.getOrDefault(node1, Collections.emptySet()).contains(node2)) {
                    --currentRank;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        // Return the maximum network rank.
        return maxRank;
    }
}