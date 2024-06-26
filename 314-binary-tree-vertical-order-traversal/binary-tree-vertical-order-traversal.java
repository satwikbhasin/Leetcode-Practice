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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        int currLevel = 0, minLevel = 0, maxLevel = 0;

        queue.offer(new Pair(root, currLevel));

        while (!queue.isEmpty()) {
            int breadth = queue.size();
            for (int i = 0; i < breadth; i++) {
                Pair<TreeNode, Integer> currPair = queue.poll();
                root = currPair.getKey();
                currLevel = currPair.getValue();
                map.computeIfAbsent(currLevel, k -> new ArrayList<>()).add(root.val);

                minLevel = Math.min(minLevel, currLevel);
                maxLevel = Math.max(maxLevel, currLevel);

                if (root.left != null) {
                    queue.offer(new Pair(root.left, currLevel - 1));
                }
                if (root.right != null) {
                    queue.offer(new Pair(root.right, currLevel + 1));
                }
            }
        }

        for (int i = minLevel; i <= maxLevel; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}