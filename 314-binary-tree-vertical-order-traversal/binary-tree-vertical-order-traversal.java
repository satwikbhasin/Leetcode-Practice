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

    TreeMap<Integer, List<Node>> map = new TreeMap<>();

    // O(n * log k) Time because it runs for each node -> O(n)
    // & for adding to treeMap -> (log k)
    private void dfs(TreeNode node, int verticalLevel, int depth) {
        if (node == null) {
            return;
        }

        // create a new node out of the current node
        Node newNode = new Node(depth, node.val);

        // Add current node's value to the list of its vertical level
        map.computeIfAbsent(verticalLevel, k -> new ArrayList<>()).add(newNode);

        // Recursively traverse left and right subtrees
        dfs(node.left, verticalLevel - 1, depth + 1);
        dfs(node.right, verticalLevel + 1, depth + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // O(n * log n)
        dfs(root, 0, 0);

        // O(n log n)
        // Convert TreeMap to a list of list by traversing each level and sorting the
        // list at each level according to depth
        List<List<Integer>> result = new ArrayList<>();
        for (List<Node> currLevel : map.values()) {
            Collections.sort(currLevel, (a, b) -> (a.depth - b.depth));
            List<Integer> temp = new ArrayList<>();
            for (Node node : currLevel) {
                temp.add(node.val);
            }
            result.add(temp);
        }

        return result;
    }
}