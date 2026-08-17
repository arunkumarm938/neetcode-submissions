class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int nextPlusOne = cost[n-1];
        int next = cost[n-2];
        for(int i = n-3; i >= 0 ; i--){
            int temp = next;
            if(next < nextPlusOne){
                next = cost[i] + next;
            }else{
                next = cost[i] + nextPlusOne;
            }
            nextPlusOne = temp;
        }
        return next < nextPlusOne ? next : nextPlusOne;
    }
}
