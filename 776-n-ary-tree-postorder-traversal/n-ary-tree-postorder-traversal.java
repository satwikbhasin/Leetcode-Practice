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
    public List<Integer> postorder(Node root) {
        List<Integer> sol = new ArrayList<>();
        if(root == null) 
            return sol;

        List<Node> children = root.children;
        if(children.isEmpty()){
                sol.add(root.val);
                return sol;        
        }

        for(Node child : children){
            for(Integer i : postorder(child)){
                sol.add(i);
            }
        }

        sol.add(root.val);
        return sol;
    }
}