// O(n * log n) Time, O(n) Space wheren is the total number of nodes
class Solution {

    class Node {
        int depth;
        int val;

        public Node(int depth, int val) {
            this.depth = depth;
            this.val = val;
        }
    }

    HashMap<Integer, List<Node>> map = new HashMap<>();

    // O(n * log k) Time because it runs for each node -> O(n)
    // & for adding to treeMap -> (log k)
    private int[] dfs(TreeNode node, int verticalLevel, int depth, int[] minMax) {
        if (node == null) {
            return minMax;
        }

        minMax[0] = Math.min(minMax[0], verticalLevel);
        minMax[1] = Math.max(minMax[1], verticalLevel);

        // create a new node out of the current node
        Node newNode = new Node(depth, node.val);

        // Add current node's value to the list of its vertical level
        map.computeIfAbsent(verticalLevel, k -> new ArrayList<>()).add(newNode);

        // Recursively traverse left and right subtrees
        dfs(node.left, verticalLevel - 1, depth + 1, minMax);
        dfs(node.right, verticalLevel + 1, depth + 1, minMax);

        return minMax;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // O(n * log n)
        int[] minMax = dfs(root, 0, 0, new int[] { 0, 0 });

        // O(n log n)
        // Convert TreeMap to a list of list by traversing each level and sorting the
        // list at each level according to depth
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minMax[0]; i <= minMax[1]; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Node> currLevel = map.get(i);
            Collections.sort(currLevel, (a, b) -> (a.depth - b.depth));
            for (Node node : currLevel) {
                temp.add(node.val);
            }
            result.add(temp);
        }

        return result;
    }
}