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
    public List<Integer> postorder(Node root) {
        if(root == null) 
            return sol;

        List<Node> children = root.children;
        if(!root.children.isEmpty()){
            for(Node child : children){
                postorder(child);
            }
        }
        sol.add(root.val);
        return sol;
    }
}