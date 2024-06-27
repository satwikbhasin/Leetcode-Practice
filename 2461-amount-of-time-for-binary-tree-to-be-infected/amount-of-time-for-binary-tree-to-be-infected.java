/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private void convertTreeToGraph(TreeNode root, HashMap<Integer, HashSet<Integer>> map) {
        if (root == null)
            return;

        map.computeIfAbsent(root.val, k -> new HashSet<Integer>());

        if (root.left != null) {
            map.get(root.val).add(root.left.val);
            map.computeIfAbsent(root.left.val, k -> new HashSet<Integer>());
            map.get(root.left.val).add(root.val);
        }

        if (root.right != null) {
            map.get(root.val).add(root.right.val);
            map.computeIfAbsent(root.right.val, k -> new HashSet<Integer>());
            map.get(root.right.val).add(root.val);
        }

        convertTreeToGraph(root.left, map);
        convertTreeToGraph(root.right, map);
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null)
            return -1;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        convertTreeToGraph(root, map);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);

        int time = -1;

        while (!queue.isEmpty()) {
            int breadth = queue.size();
            for (int i = 0; i < breadth; i++) {
                int curr = queue.poll();
                for (int n : map.get(curr)) {
                    if (!visited.contains(n)) {
                        queue.offer(n);
                        visited.add(n);
                    }
                }
            }
            time++;
        }

        return time;
    }
}