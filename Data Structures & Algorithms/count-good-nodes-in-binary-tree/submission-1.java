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
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] arr = new int[]{0};
        dfs(root, root.val, arr);
        return arr[0];
    }
    private void dfs(TreeNode root, int max, int[] arr){
        if(root == null){
            return;
        }
        System.out.println(root.val+" - "+arr[0]);
        if(root.val >= max){
            System.out.println(root.val+" "+arr[0]);
            arr[0]++;
            max = root.val;
        }
        dfs(root.left, max, arr);
        dfs(root.right, max, arr);
    }
}
