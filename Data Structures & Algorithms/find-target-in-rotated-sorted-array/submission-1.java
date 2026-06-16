class Solution {
    public int search(int[] nums, int target) {
        int tarPos = -1;
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[l] == target){
                return l;
            }else if(nums[r] == target){
                return r;
            }
            if (nums[l] <= nums[m]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < nums[m] || target > nums [r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return tarPos;
    }
}
