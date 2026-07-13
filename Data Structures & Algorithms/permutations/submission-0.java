class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        dfs(list, l, nums, new boolean[nums.length]);
        return list;
    }
    private void dfs(List<List<Integer>> list, List<Integer> l, int[] nums, boolean[] pick){
        if(l.size() == nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                l.add(nums[i]);
                pick[i]=true;
                dfs(list,l, nums,pick);
                l.remove(l.size()-1);
                pick[i]=false;
            }
        }
    }
}
