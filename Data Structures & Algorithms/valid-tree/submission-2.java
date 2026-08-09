class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> uniqueNums = new HashSet<>();
        if(!dfs(0, -1, map, uniqueNums)){
            return false;
        }
        return uniqueNums.size() == n ? true:false;
    }
    private boolean dfs(Integer i, Integer p, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        if(map.get(i) == null){
            return true;
        }
        for(Integer in:map.get(i)){
            if(p == in){
                continue;
            }
            boolean res = dfs(in, i, map, visited);
            if(!res){
                return res;
            }
        }
        return true;
    }
}
