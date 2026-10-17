class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int curr = last;
        int count = 0;
        for(int i=curr;i>=0;i--){
            if(nums[i] == val){
                int temp = nums[last];
                nums[last] = nums[i];
                nums[i]= temp;
                last--;
                count++;
            }
        }
        return nums.length - count;
    }
}