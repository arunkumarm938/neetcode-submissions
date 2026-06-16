class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = n-1;
        while(l <= r){
            if (nums[l] < nums[r]){
                min = Math.min(min, nums[l]);
                return min;
            }
            int m = l +(r - l)/2;
            min = Math.min(min, nums[m]);
            if(nums[m] >= nums[l]){
                l = m+1;
            }else {
                r = m -1;
            }
        }
        return min;
    }
}
