/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode rr, ll;
    public boolean isEnd=false;
    public boolean isValid=true;
    
    public boolean isSymmetric(TreeNode root) {
        run(root, root);
        return isValid;
    }
    
    public void run(TreeNode left, TreeNode right){
        if(isEnd || (left == null && right == null)){
            return;
        }else if((left==null || right == null) || (left.val!=right.val)){
            isEnd = true;
            isValid = false;
            return;
        }
        run(left.left, right.right);
        run(left.right, right.left);
        
    }
}