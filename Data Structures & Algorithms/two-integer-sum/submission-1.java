class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> posMap = new HashMap<Integer, Integer>();
        int[] op = new int[2];
        for(int i=0;i<nums.length;i++){
            if(posMap.containsKey(nums[i])){
                op[0]=posMap.get(nums[i]);
                op[1]=i;
            }else{
                posMap.put(target-nums[i],i);
            }
        }
        return op;
    }
}
