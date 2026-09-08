class Solution {
    public int numDistinct(String s, String t) {
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        return dfs(0, 0, s, t, memo);
    }
    private int dfs(int i, int len, String s, String t, Map<Integer, Map<Integer, Integer>> memo){
        if(len == t.length()){
            return 1;
        }
        if(i >= s.length()){
            return 0;
        }
        if(memo.containsKey(i) && memo.get(i).containsKey(len)){
            return memo.get(i).get(len);
        }
        int res = 0;
        if(s.charAt(i) == t.charAt(len)){
            res+=dfs(i+1, len+1, s, t, memo);
        }
        res+=dfs(i+1, len, s, t, memo);
        memo.putIfAbsent(i, new HashMap<Integer, Integer>());
        memo.get(i).put(len, res);
        return res;
    }
}
