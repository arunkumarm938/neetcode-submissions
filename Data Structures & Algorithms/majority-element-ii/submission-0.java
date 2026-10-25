class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> op = new ArrayList<>();
        int i=0;
        while(i < nums.length){
            int j = i+1;
            int count = 1;
            while(j < nums.length && nums[j] == nums[i]){
                j++;
                count++;
            }
            if(count > (nums.length/3)){
                op.add(nums[i]);
            }
            i=j;
        }
        return op;
    }
}