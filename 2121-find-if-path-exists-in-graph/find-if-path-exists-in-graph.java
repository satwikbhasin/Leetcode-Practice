class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while(!queue.isEmpty()){
            int vertex = queue.remove();

            for(int neighbor : graph.get(vertex)){
                if(neighbor == destination) return true;

                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return false;
    }
}