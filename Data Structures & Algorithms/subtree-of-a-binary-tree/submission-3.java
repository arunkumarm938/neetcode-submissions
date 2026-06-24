/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {\ this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val; 
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public boolean isSubtree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p != null && q != null){
            boolean val = false;
            if(p.val == q.val){
                val = isSameTree(p, q);
            }
            if(!val){
                return isSubtree(p.left, q) || isSubtree(p.right, q);
            } else {
                return val;
            }
        }else{
            return false;
        }
    }
}