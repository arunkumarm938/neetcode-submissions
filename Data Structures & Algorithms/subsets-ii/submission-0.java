class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        dfs(list, l, nums, 0);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> l, int[] nums, int i){
        if(i >= nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        dfs(list, l, nums, i+1);
        l.remove(l.size()-1);
        while(i +1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        dfs(list, l, nums, i+1);
    }
}
