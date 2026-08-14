class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] edge:times){
            map.putIfAbsent(edge[0], new HashMap<>());
            map.get(edge[0]).put(edge[1], edge[2]);
        }
        Map<Integer, Integer> visitedMap = new HashMap<>();
        for(int i=0;i<n;i++){
            visitedMap.put(i+1, Integer.MAX_VALUE);
        }
        dfs(map, visitedMap, k, 0);
        int res = -1;
        for(Map.Entry<Integer, Integer> e:visitedMap.entrySet()){
            if(e.getValue() == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, e.getValue());
        }
        return res;
    }
    private void dfs(Map<Integer, Map<Integer, Integer>> map, Map<Integer, Integer> visitedMap, int node, int count){
        if(count < visitedMap.get(node)){
            visitedMap.put(node, count);
        } else{
            return;
        }
        if(map.containsKey(node)){
            for(Map.Entry<Integer, Integer> e:map.get(node).entrySet()){
                dfs(map, visitedMap, e.getKey(), count+e.getValue());
            }
        }
    }
}
