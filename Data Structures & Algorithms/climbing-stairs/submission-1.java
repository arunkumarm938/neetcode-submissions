class Solution {
    int ans = 0;
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(n, map);
        
    }
    private int dfs(int n, Map<Integer, Integer> map){
        if(n<0){
            return 0;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==0){
            return 1;
        }
        int ans = dfs(n-1, map) + dfs(n-2, map);
        map.put(n, ans);
        return ans;
    }
}
