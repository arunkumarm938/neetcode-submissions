
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int minSubArrLen = Integer.MAX_VALUE;
        int currSum = 0;

        while (r < nums.length) {
            currSum += nums[r++];

            while (currSum >= target) {
                minSubArrLen = Math.min(minSubArrLen, r - l);
                currSum -= nums[l++];
            }
        }

        return minSubArrLen == Integer.MAX_VALUE
                ? 0 : minSubArrLen;
    }
}
