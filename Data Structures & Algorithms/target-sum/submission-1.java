class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, 0, nums, target, new HashMap<Integer, Map<Integer, Integer>>());
    }
    private int dfs(int i, int total, int[] nums, int target, Map<Integer, Map<Integer, Integer>> memo){
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        if(memo.containsKey(i) && memo.get(i).containsKey(total)){
            return memo.get(i).get(total);
        }
        int t = dfs(i+1, total+nums[i], nums, target, memo) + dfs(i+1, total-nums[i], nums, target, memo);
        memo.putIfAbsent(i, new HashMap<Integer, Integer>());
        memo.get(i).put(total, t);
        return t;
    }
}
