class Solution {
    public int findDuplicate(int[] nums) {
        for(int i:nums){
            int index = Math.abs(i) - 1;
            if(nums[index] < 0){
                return Math.abs(i);
            }else{
                nums[index] *= -1;
            }
        }
        return -1;
    }
}
