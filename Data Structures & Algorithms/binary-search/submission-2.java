class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        return bs(0, n-1, target, nums);
    }
    private int bs(int l, int r, int target, int[] nums){
        int m = (l+r)/2;
        if(l>r){
            return -1;
        }
        if(nums[m]<target){
            l=m+1;
        }else if(nums[m]>target){
            r=m-1;
        }else{
            return m;
        }
        return bs(l,r,target,nums);
    }
}
