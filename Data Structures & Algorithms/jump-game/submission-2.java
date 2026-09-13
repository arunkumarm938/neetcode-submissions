class Solution {
    public boolean canJump(int[] nums) {
        return canJump(0, nums, new HashSet<Integer>());
    }
    private boolean canJump(int i, int[] nums, Set<Integer> set){
        if(i == nums.length - 1){
            return true;
        }
        if(set.contains(i)){
            return false;
        }
        for(int j=1;j <= nums[i]; j++){
            if(i + j < nums.length && canJump(i +j, nums, set)){
                return true;
            }
        }
        set.add(i);
        return false;
    }
}
