/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node commonAncestor;
    public Set<Integer> nodeSet = new HashSet<>();
    public Node lowestCommonAncestor(Node p, Node q) {
        
        while(true){
            if(findNode(p)){
                break;
            }
            if(findNode(q)){
                break;
            }
            if(p!=null){
                p=p.parent;
            }
            if(q!=null){
                q=q.parent;
            }
        
        }
        return commonAncestor;

    }

    public boolean findNode(Node target){
        if(target == null){
            return false;
        }
        if(nodeSet.contains(target.val)){
            commonAncestor = target;
            return true;
        }
        nodeSet.add(target.val);
        return false;
    }
}