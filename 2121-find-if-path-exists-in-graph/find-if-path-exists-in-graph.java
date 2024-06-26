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
        boolean[] visited = new boolean[n];

        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int vertex = queue.remove();

            if(vertex == destination) return true;

            for(int neighbor : graph.get(vertex)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return false;
    }
}