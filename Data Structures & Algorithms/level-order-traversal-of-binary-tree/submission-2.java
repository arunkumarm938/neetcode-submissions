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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }
    private void dfs(TreeNode root, List<List<Integer>> list, int level){
        if(root == null){
            return;
        }
        System.out.println(level+" "+list.size());
        if(list.size() == level){
           List<Integer> l = new ArrayList<Integer>();
           list.add(level, l); 
        }
        list.get(level).add(root.val);
        dfs(root.left, list, level+1);
        dfs(root.right, list, level+1);
    }
}
