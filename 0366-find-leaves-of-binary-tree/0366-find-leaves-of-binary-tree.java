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
    private List<List<Integer>> answer;
    private List<Integer> childList;
    public List<List<Integer>> findLeaves(TreeNode root) {
        answer = new ArrayList<>();
        while(root != null){
            childList = new ArrayList<>();  
            root = dfs(root);    
             answer.add(childList);        
        }
        return answer;
    }

    private TreeNode dfs(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.right == null && root.left == null){     
             childList.add(root.val);
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        return root;
    }
}