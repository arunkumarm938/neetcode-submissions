class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        rec(nums, nums.length, 0, list, new ArrayList<Integer>());
        return list;
    }
    private void rec(int[] nums, int n, int i, List<List<Integer>> list, List<Integer> l){
        if(i >= n){
            list.add(l);
            return;
        }
        rec(nums, n,  i+1, list, l);
        List<Integer> newList = new ArrayList<Integer>(l);
        newList.add(nums[i]);
        rec(nums, n, i+1, list, newList);
    }
}
