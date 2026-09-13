class Solution {
    public boolean canJump(int[] nums) {
        return canJump(0, nums, new HashMap<Integer, Boolean>());
    }
    private boolean canJump(int i, int[] nums, Map<Integer, Boolean> map){
        if(i == nums.length - 1){
            return true;
        }
        if(map.containsKey(i)){
            return map.get(i);
        }
        for(int j=1;j <= nums[i]; j++){
            if(i + j < nums.length && canJump(i +j, nums, map)){
                return true;
            }
        }
        map.put(i, false);
        return false;
    }
}
