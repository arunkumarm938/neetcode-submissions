class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i = nums.length - 2;i>=0;i--){
            int j = nums[i];
            dp[i] = Integer.MAX_VALUE;
            for(int k = 1; k <= j && i + k < nums.length; k++){
                if (dp[i + k] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i+k]+1);
                }
            }
        }
        return dp[0];
    }
    
}
