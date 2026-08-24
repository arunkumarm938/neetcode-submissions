class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            int max = Math.max((nums[i] * dp[i-1]), Math.max(nums[i], nums[i] * nums[i-1]));
            int min = Math.min((nums[i] * dp[i-1]), Math.min(nums[i], nums[i] * nums[i-1]));
            nums[i] = max;
            dp[i] = min;
            res = Math.max(nums[i],res);
        }
        return res;
    }
}
