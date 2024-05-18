// class Solution {

//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         if(source == destination) return true;

//         Map<Integer, List<Integer>> graph = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             graph.put(i, new ArrayList<>());
//         }
//         for (int[] edge : edges) {
//             graph.get(edge[0]).add(edge[1]);
//             graph.get(edge[1]).add(edge[0]);
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[n];

//         queue.add(source);
//         visited[source] = true;

//         while(!queue.isEmpty()){
//             int vertex = queue.remove();

//             if(vertex == destination) return true;

//             for(int neighbor : graph.get(vertex)){
//                 if(!visited[neighbor]){
//                     queue.add(neighbor);
//                     visited[neighbor] = true;
//                 }
//             }
//         }

//         return false;
//     }
// }

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Store all edges in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Store all the nodes to be visited in 'queue'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }

            // For all the neighbors of the current node, if we haven't visit it before,            
            // add it to 'queue' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}