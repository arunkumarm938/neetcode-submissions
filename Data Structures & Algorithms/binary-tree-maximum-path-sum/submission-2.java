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
    int ovMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ovMax;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int max = Math.max(root.val, l+root.val);
        max = Math.max(max, r+root.val);
        int maxPath = max;
        max = Math.max(max, r+root.val+l);
        ovMax = Math.max(max, ovMax);
        return maxPath;
    }
}
