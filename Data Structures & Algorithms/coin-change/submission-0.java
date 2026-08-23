class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dp(0, 0, coins, amount, new HashMap<Integer, Integer>(), res);
        return res[0] != Integer.MAX_VALUE ? res[0] : -1;
    }
    private int dp(int i, int count, int[] coins, int amt, HashMap<Integer, Integer> map, int[] res){
        if(amt == 0){
            res[0] = Math.min(res[0], count);
            return res[0];
        }
        if(amt < 0){
            return Integer.MAX_VALUE;
        }
        /*if(map.containsKey(i)){
            if(map.get(i) < count){
                return map.get(i);
            }
        }*/
        int ct1 = dp(i, count+1, coins, amt - coins[i], map, res);
        if(i < coins.length -1 ){
            int ct2 = dp(i+1, count, coins, amt, map, res);
            //map.put(i, Math.min(ct1, ct2));
            res[0] = Math.min(res[0], Math.min(ct1, ct2));
        }/*else{
            map.put(i, ct1);
        }*/
        res[0] = Math.min(res[0], ct1);
        return res[0];
    }
}
