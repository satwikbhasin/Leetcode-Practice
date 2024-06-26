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

    private void dfs(TreeNode root, int verticalLevel, int depth) {
        if (root == null) {
            return;
        }

        Node newNode = new Node(depth, root.val);

        // Add current node's value to the list of its vertical level
        map.computeIfAbsent(verticalLevel, k -> new ArrayList<Node>()).add(newNode);

        // Recursively traverse left and right subtrees
        dfs(root.left, verticalLevel - 1, depth + 1);
        dfs(root.right, verticalLevel + 1, depth + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        dfs(root, 0, 0);

        // Convert HashMap to a sorted list based on keys (vertical levels)
        List<List<Integer>> result = new ArrayList<>();
        for (List<Node> currLevel : map.values()) {
            Collections.sort(currLevel, (a, b) -> (a.depth - b.depth));
            List<Integer> temp = new ArrayList<>();
            for(Node node : currLevel){
                temp.add(node.val);
            }
            result.add(temp);
        }

        return result;
    }
}