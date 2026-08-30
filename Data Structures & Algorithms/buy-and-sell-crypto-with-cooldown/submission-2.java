class Solution {
    public int maxProfit(int[] prices) {
        return dfs(0,1, prices, new HashMap<Integer, Map<Integer, Integer>>());
    }
    private int dfs(int buy, int sell, int[] prices, Map<Integer, Map<Integer, Integer>> memo){
        if(sell >= prices.length){
            return 0;
        }
        if(memo.containsKey(buy) && memo.get(buy).containsKey(sell)){
            return memo.get(buy).get(sell);
        }
        int max = prices[sell] - prices[buy];
        max = Math.max((max+dfs(sell + 2, sell+3, prices , memo)),dfs(buy, sell+1, prices, memo));
        max = Math.max(max, dfs(sell, sell+1, prices, memo));
        memo.putIfAbsent(buy, new HashMap<Integer, Integer>());
        memo.get(buy).put(sell, max);
        return max;
    }
}
