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
            collectLeafNodes(root);
            answer.add(childList);
            root = removeLeafNodes(root);            
        }
        return answer;
    }

    private void collectLeafNodes(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left==null && root.right == null){
            childList.add(root.val);
            return;
        }
        collectLeafNodes(root.left);
        collectLeafNodes(root.right);
    }

    private TreeNode removeLeafNodes(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.right == null && root.left == null){     
            return null;
        }
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }
}