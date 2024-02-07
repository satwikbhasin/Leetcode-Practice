/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> sol = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return sol;

        sol.add(root.val);
        List<Node> children = root.children;
        if(!children.isEmpty()){
            for(Node child : children){
                preorder(child);
            }
        }
        return sol;
    }
}