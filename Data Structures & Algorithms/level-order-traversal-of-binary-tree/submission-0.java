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
        if(root == null){
            return list;
        }
        TreeNode dummy = new TreeNode(1001);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(dummy);
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.println(node.val);
            if(node.val != 1001){
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                l.add(node.val);
            }else{
                if(q.size()>0){
                    TreeNode d = new TreeNode(1001);
                    q.add(d);
                }
                list.add(l);
                l = new ArrayList<>();
                System.out.println(l);
            }
        }
        return list;
    }
}
