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
    Map<TreeNode, Integer> map = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int l = 0;
        if(map.containsKey(root.left)){
            l = map.get(root.left);
        }else{
            l = height(root.left);
            map.put(root.left, l);
        }
         
        int r = 0;
        if(map.containsKey(root.right)){
            r = map.get(root.right);
        }else{
            r = height(root.right);
            map.put(root.right, r);
        }
        if(Math.abs(l - r) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
