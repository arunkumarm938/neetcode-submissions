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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, list);
        String.join("#", list);
        return String.join("#", list);
    }

    private void dfs(TreeNode root, List<String> list){
        if(root != null){
           list.add(String.valueOf(root.val));
            dfs(root.left, list);
            dfs(root.right, list);
        }else{
            list.add(String.valueOf(1001));
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>();
        String[] vals = data.split("#");
        list= Arrays.asList(vals);
        if(list.size()==0){
            return null;
        }
        int[] arr = {0};
        return revDes(arr, list);
    }

    private TreeNode revDes(int[] i, List<String> list){
        if(list.get(i[0]).equals("1001")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(i[0]++)));
        node.left = revDes(i, list);
        node.right = revDes (i, list);
        return node;
    }
}
