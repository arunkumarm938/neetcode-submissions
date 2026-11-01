class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        int count = 0;
        while(i < n){
            int num = nums[i];
            while(i < n && nums[i] == num){
                i++;
            }
            nums[count++] = num;
        }
        return count;
    }
}