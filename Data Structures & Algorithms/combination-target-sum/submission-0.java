class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<>();
        dfs(nums, 0, target, list, l);
        return list;
    }
    private void dfs(int[] nums, int i, int t,List<List<Integer>> list,  List<Integer> l){
        if(t == 0){
            list.add(new ArrayList<Integer>(l));
            return;
        }
        if(t < 0 || i >= nums.length){
            return;
        }
        l.add(nums[i]);
        dfs(nums, i, t - nums[i], list, l);
        l.remove(l.size()-1);
        dfs(nums, i+1, t, list,l);
    }
}
