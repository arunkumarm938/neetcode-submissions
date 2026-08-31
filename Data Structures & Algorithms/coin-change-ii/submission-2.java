class Solution {
    public int change(int amount, int[] coins) {
        return dfs(0, coins, amount, new HashMap<Integer, Map<Integer, Integer>>());
    }
    private int dfs(int i, int[] coins, int amount, Map<Integer, Map<Integer, Integer>> memo){
        if(i >= coins.length || amount < 0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        if(memo.containsKey(i) && memo.get(i).containsKey(amount)){
            return memo.get(i).get(amount);
        }
        int inc = dfs(i, coins, amount-coins[i], memo);
        int exc = dfs (i+1, coins, amount, memo);
        memo.putIfAbsent(i, new HashMap<Integer, Integer>());
        memo.get(i).put(amount, inc+exc);
        return inc+exc;
    }
}
