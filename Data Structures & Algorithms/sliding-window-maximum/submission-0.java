class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] op = new int[nums.length - k +1];
        int o = 0;
        for(int i=0;i< nums.length;i++){
            q.offer(new int[]{nums[i],i});
            if(i >= k - 1) {
                while(q.peek()[1] <= i-k){
                    q.poll();
                }
                op[o++]=q.peek()[0];
            }
        }
        return op;
    }
}
