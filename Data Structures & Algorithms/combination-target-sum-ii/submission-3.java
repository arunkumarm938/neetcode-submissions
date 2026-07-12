class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, list, l);
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
        int x = nums[i];
        l.add(nums[i]);
        dfs(nums, i+1, t - nums[i], list, l);
        l.remove(l.size()-1);
        while(i+1<nums.length && x == nums[i + 1]) {
            i++;
        }
        dfs(nums, i+1, t, list,l);
        
    }
}
