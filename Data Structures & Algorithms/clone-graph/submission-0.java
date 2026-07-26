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
        if(node == null || map.containsKey(node.val)){
            return node;
        }
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        Set<Integer> set = new HashSet<>();
        for(Node n:node.neighbors){
            Node newNode = dfs(n, map);
            set.add(newNode.val);
        }
        List<Node> list = new ArrayList<>();
        for(Integer i:set){
            list.add(map.get(i));
        }
        clonedNode.neighbors = list;
        return clonedNode;
    }
}