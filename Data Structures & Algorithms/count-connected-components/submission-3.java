class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int[] edge: edges){
            adjacencyList.putIfAbsent(edge[0], new ArrayList<>());
            adjacencyList.putIfAbsent(edge[1], new ArrayList<>());
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> e:adjacencyList.entrySet()){
            if(!visited.contains(e.getKey())){
                components++;
                dfs(e.getKey(), adjacencyList, visited);
            }
        }
        return components + (n - visited.size());
    }
    private void dfs(int i, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited){
        if(visited.contains(i)){
            return;
        }
        visited.add(i);
        if(adjacencyList.get(i) == null){
            return;
        }
        for(int n:adjacencyList.get(i)){
            dfs(n, adjacencyList, visited);
        }
        return;
    }
}
