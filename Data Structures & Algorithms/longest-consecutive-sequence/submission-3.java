class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int op = 1;
        int curSeq = 1;
        List<Integer> list = new ArrayList<>(set);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)==(list.get(i+1)-1)){
                curSeq++;
                op=Math.max(op,curSeq);
            }else{
                curSeq=1;
            }
        }
        return op;
    }
}
