class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j = i+1;
            int count = 1;
            while(j < nums.length && nums[j] == nums[i]){
                j++;
                count++;
            }
            if(count > nums.length/2){
                return nums[i];
            }
            i=j-1;
        }
        return -1;
    }
}