class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n == 1){
            return nums[0];
        }else if(n==2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = nums[1];
        for(int i=2;i<n;i++){
            int max = nums[0];
            for(int j=0;j<i-1;j++){
                max=Math.max(max, res[j]);
            }
            res[i]=nums[i]+max;
        }
        int max=nums[0];
        for(int i=0;i<n;i++){
            max=Math.max(res[i], max);
        }
        return max;
    }
}
