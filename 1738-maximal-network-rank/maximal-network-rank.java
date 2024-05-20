class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length == 0) return 0;

        Map<Integer, Integer> cityConnections = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < roads.length; i++) {
            if (graph.containsKey(roads[i][0]) && cityConnections.containsKey(roads[i][0])) {
                graph.get(roads[i][0]).add(roads[i][1]);
                cityConnections.put(roads[i][0], cityConnections.get(roads[i][0]) + 1);
            } else {
                graph.put(roads[i][0], new HashSet<>());
                graph.get(roads[i][0]).add(roads[i][1]);
                cityConnections.put(roads[i][0], 1);
            }

            if (graph.containsKey(roads[i][1]) && cityConnections.containsKey(roads[i][1])) {
                graph.get(roads[i][1]).add(roads[i][0]);
                cityConnections.put(roads[i][1], cityConnections.get(roads[i][1]) + 1);
            } else {
                graph.put(roads[i][1], new HashSet<>());
                graph.get(roads[i][1]).add(roads[i][0]);
                cityConnections.put(roads[i][1], 1);
            }
        }

        int maxNetworkRank = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && cityConnections.get(i) != null && cityConnections.get(j) != null) {
                    int networkRank = cityConnections.get(i) + cityConnections.get(j);
                    if (graph.get(i).contains(j))
                        networkRank--;
                    maxNetworkRank = maxNetworkRank > networkRank ? maxNetworkRank : networkRank;
                }
            }
        }

        return maxNetworkRank;
    }
}