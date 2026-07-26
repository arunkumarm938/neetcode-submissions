/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    private Node dfs(Node node, Map<Integer, Node> map){
        if(node == null){
            return node;
        }
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        List<Node> list = new ArrayList<>();
        for(Node n:node.neighbors){
            Node newNode = dfs(n, map);
            list.add(newNode);
        }
        clonedNode.neighbors = list;
        return clonedNode;
    }
}